package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.ProductRepositoryJpa;
import br.com.lfmelo.core.domains.products.Product;
import br.com.lfmelo.core.ports.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {

    @Autowired
    private ProductRepositoryJpa productRepositoryJpa;

    @Override
    public ProductEntity findProductById(Long idProduct) {
        return productRepositoryJpa.findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }
}
