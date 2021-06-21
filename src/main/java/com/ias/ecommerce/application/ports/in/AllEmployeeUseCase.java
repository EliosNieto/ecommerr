package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.employee.ListEmployeeRequest;
import com.ias.ecommerce.application.model.employee.ListEmployeeResponse;

public interface AllEmployeeUseCase extends ApplicationUseCase<ListEmployeeRequest, ListEmployeeResponse> {
}
