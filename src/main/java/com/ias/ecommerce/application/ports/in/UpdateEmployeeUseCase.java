package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.crud.UpdateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.UpdateEmployeeResponse;

public interface UpdateEmployeeUseCase extends ApplicationUseCase<UpdateEmployeeRequest, UpdateEmployeeResponse> {
}
