package br.com.lfmelo.consumers;

import br.com.lfmelo.entities.OrderCheckoutDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CheckoutConsumer {

    @SqsListener("checkout-order")
    public void listen(OrderCheckoutDTO message) {
        log.info("Mensagem received: {}", message);
    }

}
