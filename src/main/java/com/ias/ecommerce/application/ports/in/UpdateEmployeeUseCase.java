package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.UpdateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.UpdateEmployeeResponse;

public interface UpdateEmployeeUseCase extends ApplicationUseCase<UpdateEmployeeRequest, UpdateEmployeeResponse> {
}
