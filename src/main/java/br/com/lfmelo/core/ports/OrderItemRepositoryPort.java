package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.OrderItemEntity;

import java.util.List;

public interface OrderItemRepositoryPort {
    void saveOrderItems(List<OrderItemEntity> orderItemEntities);
}
