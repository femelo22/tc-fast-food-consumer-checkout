package br.com.lfmelo.application.services;

import br.com.lfmelo.adapters.driven.entities.OrderEntity;
import br.com.lfmelo.adapters.driven.entities.OrderItemEntity;
import br.com.lfmelo.adapters.dtos.OrderCheckoutDTO;
import br.com.lfmelo.adapters.dtos.OrderItemDTO;
import br.com.lfmelo.core.ports.OrderItemRepositoryPort;
import br.com.lfmelo.core.ports.OrderItemServicePort;
import br.com.lfmelo.core.ports.ProductServicePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderItemsServiceImpl implements OrderItemServicePort {

    @Autowired
    private OrderItemRepositoryPort orderItemRepositoryPort;

    @Autowired
    private ProductServicePort productServicePort;

    @Override
    public void saveOrderItems(OrderCheckoutDTO dto, OrderEntity order) {
        List<OrderItemEntity> orderItemEntities = new ArrayList<>();

        for (OrderItemDTO item: dto.getOrderItems()) {

            log.info("Buscando produto ID = {}", item.getProductId());
            var product = productServicePort.findById(item.getProductId());

            var orderItemEntity = new OrderItemEntity();
            orderItemEntity.setProduct(product);
            orderItemEntity.setOrder(order);
            orderItemEntity.setAmount(item.getQuantity());
            orderItemEntity.setUnitPrice(product.getPrice());
            orderItemEntity.setNote(item.getNote());

            log.info("Adicionando item para salvar");
            log.info(orderItemEntity.toString());

            orderItemEntities.add(orderItemEntity);
        }

       orderItemRepositoryPort.saveOrderItems(orderItemEntities);
    }
}
