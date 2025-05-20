package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.OrderRepositoryJpa;
import br.com.lfmelo.core.domains.orders.Order;
import br.com.lfmelo.core.ports.OrderRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryPort {

    @Autowired
    OrderRepositoryJpa orderRepositoryJpa;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderEntity createOrder(Order order, ClientEntity clientEntity) {
        var orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity.setClient(clientEntity);
        return orderRepositoryJpa.save(orderEntity);
    }
}
