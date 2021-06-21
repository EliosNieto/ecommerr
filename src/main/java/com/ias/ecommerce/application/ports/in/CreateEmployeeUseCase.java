package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.CreateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.CreateEmployeeResponse;

public interface CreateEmployeeUseCase extends ApplicationUseCase<CreateEmployeeRequest, CreateEmployeeResponse> {
}
