package hust.project.gioimon.adm_client.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
@Slf4j
public enum ErrorsDefinition implements TypeError {

    BAD_REQUEST(1,
            "common.error.bad.request",
            HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(2,
            "common.error.unauthorized",
            HttpStatus.UNAUTHORIZED),
    FORBIDDEN(3,
            "common.error.forbidden",
            HttpStatus.FORBIDDEN),
    NOT_FOUND(4,
            "common.error.not.found",
            HttpStatus.NOT_FOUND),
    METHOD_NOT_ALLOWED(5,
            "common.error.method.not.allow",
            HttpStatus.METHOD_NOT_ALLOWED),
    DATA_INTEGRITY_VIOLATION(6,
            "common.error.data.violation",
            HttpStatus.CONFLICT),
    MISSING_REQUEST_PARAMETER(7,
            "common.error.missing.parameter",
            HttpStatus.BAD_REQUEST),

    INTERNAL_SERVER_ERROR(13,
            "common.error.server.error",
            HttpStatus.INTERNAL_SERVER_ERROR),
    ACCESS_TOKEN_INVALID(14,
           "common.error.access.token.invalid",
            HttpStatus.UNAUTHORIZED),
    APPLICATION_ERROR(19, "%s", HttpStatus.BAD_REQUEST),
    API_EXCEPTION(20, "%s", HttpStatus.BAD_REQUEST),
    APPLICATION_EXCEPTION(99, "%s", HttpStatus.BAD_REQUEST),

    USER_DOES_NOT_EXIST_EXCEPTION(1001, "%s", HttpStatus.BAD_REQUEST),
    USERNAME_EXISTED_EXCEPTION(1002, "%s", HttpStatus.BAD_REQUEST)
    ;


    private final int code;

    private final String message;

    private final HttpStatus httpStatus;

    ErrorsDefinition(int code, String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static ErrorsDefinition of(Exception ex) {
        try {
            String classError = ex.getClass().getSimpleName();
            log.info("@@@@@" + classError);
            OBJECT_ERROR objectName = OBJECT_ERROR.valueOf(classError);
            log.info("####" + objectName);
            return switch (objectName) {
                case UsernameExistedException -> USERNAME_EXISTED_EXCEPTION;
                case UserDoesNotExistException -> USER_DOES_NOT_EXIST_EXCEPTION;
                case ApplicationException -> APPLICATION_EXCEPTION;
                default -> INTERNAL_SERVER_ERROR;
            };
        } catch (Exception e) {
            return INTERNAL_SERVER_ERROR;
        }
    }

    enum OBJECT_ERROR {
        UsernameExistedException,
        UserDoesNotExistException,
        ApplicationException,

    }
}
