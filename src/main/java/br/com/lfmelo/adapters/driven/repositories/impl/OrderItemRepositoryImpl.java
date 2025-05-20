package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.OrderItemEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.OrderItemRepositoryJpa;
import br.com.lfmelo.core.ports.OrderItemRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepositoryPort {

    @Autowired
    private OrderItemRepositoryJpa orderItemRepositoryJpa;

    @Override
    public void saveOrderItems(List<OrderItemEntity> orderItemEntities) {
        orderItemRepositoryJpa.saveAll(orderItemEntities);
    }
}
