package br.com.lfmelo.adapters.driven.consumers;

import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.application.services.OrderServiceImpl;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.model.ListQueuesResponse;

@Component
@Slf4j
public class CheckoutConsumer {

    @Autowired
    private OrderServiceImpl orderService;

    @SqsListener("checkout-order")
    public void listen(OrderCheckoutDTO message) {
        try {
            log.info("Mensagem received: {}", message);
            orderService.createOrder(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar mensagem: " + e.getMessage());
        }

    }

}
