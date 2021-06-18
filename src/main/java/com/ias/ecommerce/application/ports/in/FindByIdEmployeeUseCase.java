package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.crud.FindByIdEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.FindByIdEmployeeResponse;

public interface FindByIdEmployeeUseCase extends ApplicationUseCase<FindByIdEmployeeRequest, FindByIdEmployeeResponse> {
}
