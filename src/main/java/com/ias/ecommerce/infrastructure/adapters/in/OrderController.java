package com.ias.ecommerce.infrastructure.adapters.in;

import com.ias.ecommerce.application.model.orders.*;
import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.infrastructure.commons.UseCaseHttpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateOrderUseCase createOrderUseCase;
    private final DeleteOrderUseCase deleteOrderUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;
    private final FindByIdOrderUseCase findByIdOrderUseCase;
    private final AllOrderUseCase allOrderUseCase;

    @Autowired
    public OrderController(UseCaseHttpExecutor useCaseHttpExecutor, CreateOrderUseCase createOrderUseCase, DeleteOrderUseCase deleteOrderUseCase, UpdateOrderUseCase updateOrderUseCase, FindByIdOrderUseCase findByIdOrderUseCase, AllOrderUseCase allOrderUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createOrderUseCase = createOrderUseCase;
        this.deleteOrderUseCase = deleteOrderUseCase;
        this.updateOrderUseCase = updateOrderUseCase;
        this.findByIdOrderUseCase = findByIdOrderUseCase;
        this.allOrderUseCase = allOrderUseCase;
    }

    @GetMapping
    public ResponseEntity listOrderHandler(){
        return useCaseHttpExecutor.executeUseCase(allOrderUseCase, new ListOrderRequest());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findByIdOrderHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(findByIdOrderUseCase, new FindByIdOrderRequest(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteOrderHandler(@PathVariable String id){
        return useCaseHttpExecutor.executeUseCase(deleteOrderUseCase, new DeleteOrderRequest(id));
    }

    @PostMapping
    public ResponseEntity createOrderHandler(@RequestBody CreateOrderRequest createOrderRequest){
        return useCaseHttpExecutor.executeUseCase(createOrderUseCase, createOrderRequest);
    }

    @PutMapping
    public ResponseEntity updateOrderHandler(@RequestBody UpdateOrderRequest updateOrderRequest){
        return useCaseHttpExecutor.executeUseCase(updateOrderUseCase, updateOrderRequest);
    }
}
