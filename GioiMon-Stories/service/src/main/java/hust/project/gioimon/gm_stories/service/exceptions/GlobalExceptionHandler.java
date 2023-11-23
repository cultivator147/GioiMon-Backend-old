package hust.project.gioimon.gm_stories.service.exceptions;

import hust.project.gioimon.gm_stories.client.exceptions.ErrorsDefinition;
import hust.project.gioimon.gm_stories.client.model.ResponseData;
import hust.project.gioimon.gm_stories.service.utils.BaseResponse;
import hust.project.gioimon.gm_stories.service.exceptions.custom.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public  ResponseEntity<ResponseData<Object>> handleApplicationException(ApplicationException ex){
//        log.error(ex.getMessage(), ex);
        return this.handleError(ErrorsDefinition.of(ex), ex.getMessage());
    }
    private ResponseEntity<ResponseData<Object>> handleError(ErrorsDefinition commonError,  String messageArg) {
        String message = commonError.getMessage();
        int code = commonError.getCode();
        if (messageArg != null) {
            message = String.format(message, messageArg);
        }
        HttpStatus httpStatus = commonError.getHttpStatus();
        return BaseResponse.error(code, message, httpStatus);
    }
}
