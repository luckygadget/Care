package care.connect.care.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException {

    private final String message;
    private final String errorCode;
    private final int status;

    public ApiException(String message, HttpStatus status, String errorCode) {
        this.message = message;
        this.status = status.value();
        this.errorCode = errorCode;
    }
}