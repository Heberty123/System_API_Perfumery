package Loja.Amelia.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConflictCPFAlreadyExist.class)
    public ResponseEntity<Object> handleExceptionsCPFUnique(ConflictCPFAlreadyExist exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(String.format("CPF %s already exist !", exception.getCPF()));
        response.setError("error client side");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.CONFLICT);
        return entity;
    }
}
