package br.com.lfmelo.adapters.driven.consumers;

import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.application.services.OrderServiceImpl;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CheckoutConsumer {

    @Autowired
    private OrderServiceImpl orderService;

    @SqsListener("checkout-order")
    public void listen(OrderCheckoutDTO message) {
        log.info("Mensagem received: {}", message);
        orderService.createOrder(message);
    }

}
