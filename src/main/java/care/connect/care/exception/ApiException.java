package care.connect.care.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiException {

    private String message;
    private HttpStatus status;
    private String errorCode;



}
