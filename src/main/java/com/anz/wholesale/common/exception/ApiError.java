package com.anz.wholesale.common.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
    private String errorId;
    private String message;
}
