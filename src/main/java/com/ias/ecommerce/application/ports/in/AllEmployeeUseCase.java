package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.crud.AllEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.AllEmployeeResponse;

public interface AllEmployeeUseCase extends ApplicationUseCase<AllEmployeeRequest, AllEmployeeResponse> {
}
