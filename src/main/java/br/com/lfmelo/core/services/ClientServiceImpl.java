package br.com.lfmelo.core.services;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.ports.ClientRepositoryPort;
import br.com.lfmelo.core.ports.ClientServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientServicePort {

    @Autowired
    private ClientRepositoryPort clientRepositoryPort;

    @Override
    public ClientEntity findById(Long id) {
        return clientRepositoryPort.findById(id);
    }
}
