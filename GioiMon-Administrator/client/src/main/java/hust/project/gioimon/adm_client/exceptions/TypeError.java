package hust.project.gioimon.adm_client.exceptions;

import org.springframework.http.HttpStatus;

public interface TypeError {
    String getMessage();

    int getCode();

    HttpStatus getHttpStatus();
}
