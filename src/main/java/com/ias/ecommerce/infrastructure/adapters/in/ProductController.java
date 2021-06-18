package com.ias.ecommerce.infrastructure.adapters.in;

import com.ias.ecommerce.application.model.product.*;
import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.infrastructure.commons.UseCaseHttpExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateProductUseCase createProductUseCase;
    private final AllProductUseCase allProductService;
    private final FindByIdProductUseCase findByIdProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    @Autowired
    public ProductController(UseCaseHttpExecutor useCaseHttpExecutor,
                             CreateProductUseCase createProductUseCase,
                             AllProductUseCase allProductService,
                             FindByIdProductUseCase findByIdProductUseCase,
                             DeleteProductUseCase deleteProductUseCase,
                             UpdateProductUseCase updateProductUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createProductUseCase = createProductUseCase;
        this.allProductService = allProductService;
        this.findByIdProductUseCase = findByIdProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }

    @PostMapping
    public ResponseEntity createStudentHandler(@RequestBody CreateProductRequest request){
        return useCaseHttpExecutor.executeUseCase(createProductUseCase, request);
    }

    @GetMapping
    public ResponseEntity listProductHandler(){
        return useCaseHttpExecutor.executeUseCase(allProductService, new AllProductRequest());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getProductHandler(@PathVariable String id){
        logger.info(id);
        return useCaseHttpExecutor.executeUseCase(findByIdProductUseCase,
                                                new FindByIdProductRequest(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteProductHandler(@PathVariable String id){
        logger.info("controller Del:");
        return useCaseHttpExecutor.executeUseCase(deleteProductUseCase,   new DeleteProductRequest(id));
    }

    @PutMapping
    private ResponseEntity updateProductHandler(@RequestBody UpdateProductRequest request){

        return useCaseHttpExecutor.executeUseCase(updateProductUseCase,request);

    }

}
