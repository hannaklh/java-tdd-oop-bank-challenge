package com.booleanuk.core.dto;

import java.math.BigDecimal;

public class TransactionResult {
    private boolean success;
    private String message;

    public TransactionResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success;    }

    public String getMessage() { return message; }

}
