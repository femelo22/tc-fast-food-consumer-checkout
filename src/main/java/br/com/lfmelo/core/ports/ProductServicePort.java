package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;

public interface ProductServicePort {
    ProductEntity findById(Long idProduct);
}