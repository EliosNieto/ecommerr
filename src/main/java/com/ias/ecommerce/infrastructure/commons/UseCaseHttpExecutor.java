package com.ias.ecommerce.infrastructure.commons;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.operation.ApplicationRequest;
import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UseCaseHttpExecutor {

    Logger logger = LoggerFactory.getLogger(UseCaseHttpExecutor.class);

    public <IN extends ApplicationRequest, OUT extends ApplicationResponse>ResponseEntity executeUseCase(
        ApplicationUseCase<IN, OUT> useCase,
        IN applicationRequest
    ){
        try {
            logger.info("ejecutando caso de uso");
            OUT response = useCase.execute(applicationRequest);
            logger.info("Respuesta: "+response);
            return ResponseEntity.status(response.statusResponse()).body(response);
        } catch ( ApplicationError e){
            logger.info("error1: ");
            int httpStatus = e.httpStatusCode().getCode();
            Map<String, Object> body = Map.of(
                    "message", e.getMessage(),
                    "errorCode", e.errorCode(),
                    "metadata", e.metadata()
            );
            return ResponseEntity.status(httpStatus).body(body);
        }catch (Exception e){
            logger.info("error2: "+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
