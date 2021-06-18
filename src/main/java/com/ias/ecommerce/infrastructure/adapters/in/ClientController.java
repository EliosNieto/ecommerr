package com.ias.ecommerce.infrastructure.adapters.in;

import com.ias.ecommerce.application.model.client.crud.*;
import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.infrastructure.commons.UseCaseHttpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateClientUseCase createClientUseCase;
    private final AllClientUseCase allClientUseCase;
    private final FindByIdClientUseCase findByIdClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;

    @Autowired
    public ClientController(UseCaseHttpExecutor useCaseHttpExecutor, CreateClientUseCase createClientUseCase, AllClientUseCase allClientUseCase, FindByIdClientUseCase findByIdClientUseCase, DeleteClientUseCase deleteClientUseCase, UpdateClientUseCase updateClientUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createClientUseCase = createClientUseCase;
        this.allClientUseCase = allClientUseCase;
        this.findByIdClientUseCase = findByIdClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.updateClientUseCase = updateClientUseCase;
    }

    @GetMapping
    public ResponseEntity listClientsHandler(){
        return useCaseHttpExecutor.executeUseCase(allClientUseCase, new AllClientRequest());
    }

    @PostMapping
    public ResponseEntity createClientHandler(@RequestBody CreateClientRequest createClientRequest){
        return useCaseHttpExecutor.executeUseCase(createClientUseCase, createClientRequest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity FindByIdClientHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(findByIdClientUseCase, new FindByIdClientRequest(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteClientHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(deleteClientUseCase, new DeleteClientRequest(id));
    }

    @PutMapping
    public ResponseEntity updateClientHandler(@RequestBody UpdateClientRequest updateClientRequest){
        return useCaseHttpExecutor.executeUseCase(updateClientUseCase,updateClientRequest);
    }
}
