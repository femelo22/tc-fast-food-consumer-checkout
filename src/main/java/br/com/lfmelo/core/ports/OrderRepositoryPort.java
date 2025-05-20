package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.core.domains.orders.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface OrderRepositoryPort {
    OrderEntity createOrder(Order order, ClientEntity clientEntity);
}
