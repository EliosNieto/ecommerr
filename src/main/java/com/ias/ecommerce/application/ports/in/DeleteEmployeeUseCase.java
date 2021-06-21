package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.DeleteEmployeeRequest;
import com.ias.ecommerce.application.model.employee.DeleteEmployeeResponse;

public interface DeleteEmployeeUseCase extends ApplicationUseCase<DeleteEmployeeRequest, DeleteEmployeeResponse> {
}
