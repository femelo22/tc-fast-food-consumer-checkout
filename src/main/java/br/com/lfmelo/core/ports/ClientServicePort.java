package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;

public interface ClientServicePort {
    ClientEntity findById(Long id);
}
