package lipe.dev.bank.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RequiredArgsConstructor
final public class ApiErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException exception, Locale locale)
    {
        return ResponseEntity.unprocessableEntity().body(null);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity invalidFormatException(InvalidFormatException exception, Locale locale)
    {
        return ResponseEntity.unprocessableEntity().body(null);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity invalidFormatException(BusinessException exception, Locale locale)
    {
        return ResponseEntity.unprocessableEntity().body(null);
    }

}