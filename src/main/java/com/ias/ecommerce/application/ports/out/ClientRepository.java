package com.ias.ecommerce.application.ports.out;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void save(Client client);

    Optional<Client> findById(IdentificationNumber id);

    void delete(IdentificationNumber id);

    void update(Client client);

    Optional<Collection<Client>> getAll();

}
