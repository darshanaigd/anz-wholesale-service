package com.anz.wholesale.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class AccountClientException extends RuntimeException {
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String errorId;

    public AccountClientException(HttpStatus httpStatus, String errorId) {
        super(errorId);
        this.httpStatus = httpStatus;
        this.errorId = errorId;
    }
}
