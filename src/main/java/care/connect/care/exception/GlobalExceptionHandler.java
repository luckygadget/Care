package care.connect.care.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiException> handleNotFound(ResourceNotFoundException ex) {
        ApiException error = new ApiException(ex.getMessage(), HttpStatus.NOT_FOUND, "NOT_FOUND");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiException> handleBadRequest(BadRequestException ex) {
        ApiException error = new ApiException(ex.getMessage(), HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ApiException error = new ApiException(message, HttpStatus.BAD_REQUEST, "VALIDATION_ERROR");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleGeneric(Exception ex) {
        ApiException error = new ApiException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_ERROR");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
