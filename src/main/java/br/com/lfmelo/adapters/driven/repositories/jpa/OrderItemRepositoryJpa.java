package br.com.lfmelo.adapters.driven.repositories.jpa;

import br.com.lfmelo.adapters.driven.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepositoryJpa extends JpaRepository<OrderItemEntity, Long> {
}
