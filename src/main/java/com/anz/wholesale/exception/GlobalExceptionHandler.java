package com.anz.wholesale.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(AccountClientException.class)
    public ResponseEntity<ApiError> handleAccountClientException(AccountClientException exception) {
        log.error(exception.getMessage(), exception);

        ApiError apiError = ApiError.builder()
                .errorId(exception.getErrorId())
                .message(messageSource.getMessage(exception.getErrorId(), null, LocaleContextHolder.getLocale())).build();

        return new ResponseEntity<>(apiError, exception.getHttpStatus());
    }

}
