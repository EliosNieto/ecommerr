package com.ias.ecommerce.infrastructure.persistence.common.mappers;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.IdentificationNumberMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NomEmptyStringMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring" , uses = {IdentificationNumberMapper.class, NomEmptyStringMapper.class})
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "id", target = "identificationNumber"),
            @Mapping(source = "names", target = "names"),
            @Mapping(source = "lastNames", target = "lastNames")
    })
    Client toClient(ClientEntity clientEntity);
    Collection<Client> toClients(Iterable<ClientEntity> clientEntities);

    @InheritInverseConfiguration
    ClientEntity toClientEntity(Client client);
}
