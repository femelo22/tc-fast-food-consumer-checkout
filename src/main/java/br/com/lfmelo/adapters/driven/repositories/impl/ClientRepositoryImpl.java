package br.com.lfmelo.adapters.driven.repositories.impl;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.adapters.driven.repositories.jpa.ClientRepositoryJpa;
import br.com.lfmelo.core.ports.ClientRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepositoryPort {

    @Autowired
    private ClientRepositoryJpa clientRepositoryJpa;

    @Override
    public ClientEntity findById(Long id) {
        return clientRepositoryJpa.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cliente %s não encontrado!", id)));
    }
}