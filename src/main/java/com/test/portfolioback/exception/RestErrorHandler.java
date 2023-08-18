package com.test.portfolioback.exception;

import com.test.portfolioback.model.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Robson J Silva <vantrox@yahoo.com.br>
 */
@ControllerAdvice
@Slf4j
public class RestErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorModel processValidationError(NotFoundException ex) {
        String result = ex.getMessage();
        log.warn(result);
        ErrorModel error = new ErrorModel(result);
        return error;
    }
}
