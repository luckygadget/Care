package care.connect.care.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiException extends Throwable {

    private String message;
    private HttpStatus status;
    private String errorCode;


    public ApiException(String emailAlreadyExist) {
    }
}
