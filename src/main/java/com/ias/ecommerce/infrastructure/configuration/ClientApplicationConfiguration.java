package com.ias.ecommerce.infrastructure.configuration;

import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.application.services.*;
import com.ias.ecommerce.infrastructure.adapters.out.ClientRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientApplicationConfiguration {

    @Bean
    public CreateClientUseCase createClientUseCase(ClientRepositoryImpl clientRepository){
        return new CreateClientService(clientRepository);
    }

    @Bean
    public AllClientUseCase allClientUseCase(ClientRepositoryImpl clientRepository){
        return new AllClientService(clientRepository);
    }

    @Bean
    public FindByIdClientUseCase findByIdClientUseCase(ClientRepositoryImpl clientRepository){
        return new FindByIdClientService(clientRepository);
    }

    @Bean
    public UpdateClientUseCase updateClientUseCase(ClientRepositoryImpl clientRepository){
        return new UpdateClientService(clientRepository);
    }

    @Bean
    public DeleteClientUseCase deleteClientUseCase(ClientRepositoryImpl clientRepository){
        return new DeleteClientService(clientRepository);
    }

}
