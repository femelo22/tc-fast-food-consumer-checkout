package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;

public interface OrderItemServicePort {
    void saveOrderItems(OrderCheckoutDTO dto, OrderEntity order);
}
