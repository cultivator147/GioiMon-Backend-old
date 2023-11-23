package hust.project.gioimon.gm_stories.client.exceptions;

import org.springframework.http.HttpStatus;

public interface TypeError {
    String getMessage();

    int getCode();

    HttpStatus getHttpStatus();
}
