package com.ias.ecommerce.infrastructure.adapters.out;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.ClientMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.ClientEntity;
import com.ias.ecommerce.infrastructure.persistence.repository.ClientRepositoryJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class ClientRepositoryImpl implements ClientRepository {

    private Logger logger = LoggerFactory.getLogger(ClientRepositoryImpl.class);

    private final ClientRepositoryJpa clientRepositoryJpa;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientRepositoryImpl(ClientRepositoryJpa clientRepositoryJpa, ClientMapper clientMapper) {
        this.clientRepositoryJpa = clientRepositoryJpa;
        this.clientMapper = clientMapper;
    }

    @Override
    public void save(Client client) {
        ClientEntity clientEntity = clientMapper.toClientEntity(client);
        this.clientRepositoryJpa.save(clientEntity);
    }

    @Override
    public Optional<Client> findById(IdentificationNumber id) {
        Optional<ClientEntity> optionalClient = clientRepositoryJpa.findById(id.getValue());
        if(!optionalClient.isPresent()){
            return Optional.empty();
        }

        return optionalClient.map(clientEntity -> clientMapper.toClient(clientEntity));
    }

    @Override
    public void delete(IdentificationNumber id) {
        clientRepositoryJpa.deleteById(id.getValue());
    }

    @Override
    public void update(Client client) {
        ClientEntity clientEntity = clientMapper.toClientEntity(client);
        clientRepositoryJpa.save(clientEntity);
    }

    @Override
    public Optional<Collection<Client>> getAll() {
        Iterable<ClientEntity> clientEntities = clientRepositoryJpa.findAll();
        clientEntities.forEach(clientEntity -> logger.info(clientEntity.toString()));
        Collection<Client> clientList = clientMapper.toClients(clientEntities);
        clientList.stream().forEach(client -> logger.info(client.toString()));
        return Optional.of(clientList);
    }
}
