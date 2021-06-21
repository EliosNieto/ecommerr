package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.FindByIdEmployeeRequest;
import com.ias.ecommerce.application.model.employee.FindByIdEmployeeResponse;

public interface FindByIdEmployeeUseCase extends ApplicationUseCase<FindByIdEmployeeRequest, FindByIdEmployeeResponse> {
}
