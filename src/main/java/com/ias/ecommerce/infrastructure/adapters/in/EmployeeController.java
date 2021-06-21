package com.ias.ecommerce.infrastructure.adapters.in;

import com.ias.ecommerce.application.model.employee.*;
import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.infrastructure.commons.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final AllEmployeeUseCase allEmployeeUseCase;
    private final FindByIdEmployeeUseCase findByIdEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    public EmployeeController(UseCaseHttpExecutor useCaseHttpExecutor, CreateEmployeeUseCase createEmployeeUseCase, AllEmployeeUseCase allEmployeeUseCase, FindByIdEmployeeUseCase findByIdEmployeeUseCase, UpdateEmployeeUseCase updateEmployeeUseCase, DeleteEmployeeUseCase deleteEmployeeUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createEmployeeUseCase = createEmployeeUseCase;
        this.allEmployeeUseCase = allEmployeeUseCase;
        this.findByIdEmployeeUseCase = findByIdEmployeeUseCase;
        this.updateEmployeeUseCase = updateEmployeeUseCase;
        this.deleteEmployeeUseCase = deleteEmployeeUseCase;
    }

    @PostMapping
    public ResponseEntity createEmployeeHandler(@RequestBody CreateEmployeeRequest request){
        return useCaseHttpExecutor.executeUseCase(createEmployeeUseCase,request);
    }

    @GetMapping
    public ResponseEntity getAllEmployeeHandler(){
        return useCaseHttpExecutor.executeUseCase(allEmployeeUseCase, new ListEmployeeRequest());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getFindByIdEmployeeHandler(@PathVariable String id ){
        return useCaseHttpExecutor.executeUseCase(findByIdEmployeeUseCase, new FindByIdEmployeeRequest(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteEmployeeHandler(@PathVariable String id ){
        return useCaseHttpExecutor.executeUseCase(deleteEmployeeUseCase, new DeleteEmployeeRequest(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateEmployeeHandler(@PathVariable String id, @RequestBody UpdateEmployeeRequest request){
        request.setId(id);
        return useCaseHttpExecutor.executeUseCase(updateEmployeeUseCase, request);
    }
}










