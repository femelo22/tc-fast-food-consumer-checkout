package br.com.lfmelo.application.services;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.core.domains.enums.StatusOrder;
import br.com.lfmelo.core.domains.orders.Order;
import br.com.lfmelo.core.ports.ClientServicePort;
import br.com.lfmelo.core.ports.OrderItemServicePort;
import br.com.lfmelo.core.ports.OrderRepositoryPort;
import br.com.lfmelo.core.ports.OrderServicePort;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderServicePort {

    @Autowired
    private OrderRepositoryPort orderRepositoryPort;

    @Autowired
    private OrderItemServicePort orderItemServicePort;

    @Autowired
    private ClientServicePort clientServicePort;

    private ClientEntity client = null;

    @Override
    @Transactional
    public void createOrder(OrderCheckoutDTO dto) {
        var order = new Order();

        if(!Objects.isNull(dto.getClientId())) {
            log.info("Buscando cliente informado: {}", dto.getClientId());
            client = clientServicePort.findById(dto.getClientId());
        }

        order.setOrderDate(LocalDateTime.now());
        order.setTotal(dto.getTotalPrice());
        order.setStatus(StatusOrder.FINISHED); //TODO: (por hora, ele finaliza aqui)
        order.setAlias("ORDER-".concat(UUID.randomUUID().toString().substring(0, 7)));

        log.info("Salvando pedido [Transactional]..");
        OrderEntity orderSaved = orderRepositoryPort.createOrder(order, client);

        log.info("Enviando itens do pedido para processameto e conclusão.");
        orderItemServicePort.saveOrderItems(dto, orderSaved);

        log.info("Pedido {} recebiddo e processado com sucesso! \n Data {}", orderSaved.getId(), orderSaved.getOrderDate());
    }
}
