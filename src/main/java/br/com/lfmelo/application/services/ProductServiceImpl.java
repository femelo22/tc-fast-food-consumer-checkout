package br.com.lfmelo.application.services;

import br.com.lfmelo.adapters.driven.entities.ProductEntity;
import br.com.lfmelo.core.ports.ProductRepositoryPort;
import br.com.lfmelo.core.ports.ProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductServicePort {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    @Override
    public ProductEntity findById(Long idProduct) {
        return productRepositoryPort.findProductById(idProduct);
    }

}
