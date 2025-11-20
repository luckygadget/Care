package care.connect.care.exception;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
