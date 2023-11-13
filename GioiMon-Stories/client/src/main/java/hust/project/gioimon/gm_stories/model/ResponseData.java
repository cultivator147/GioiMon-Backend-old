package hust.project.gioimon.gm_stories.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class ResponseData<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private int status;

    private T data;
    public ResponseData<T> success() {
        this.code = 0;
        this.message = "Successful!";
        this.status = 200;
        return this;
    }

    public ResponseData<T> success(T data) {
        this.code = 0;
        this.message = "Successful!";
        this.status = 200;
        this.data = data;
        return this;
    }

    public ResponseData<T> error(int code, String message, int status) {
        this.code = code;
        this.message = message;
        this.status = status;
        return this;
    }
}
