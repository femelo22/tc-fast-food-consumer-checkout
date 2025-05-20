package br.com.lfmelo.core.ports;

import br.com.lfmelo.adapters.driven.entities.ClientEntity;
import br.com.lfmelo.core.domains.clients.Client;

public interface ClientServicePort {
    ClientEntity findById(Long id);
}
