/*
 * Copyright (c) 2017. Shanghai Zhenhui Information Technology Co,. ltd.
 * All rights are reserved.
 */

package com.example.demo.exception.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markfredchen on 3/26/15.
 */
public class ValidationException extends RuntimeException {

    private List<ValidationError> validationErrors = new ArrayList<ValidationError>();

    public ValidationException(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public ValidationException(ValidationError validationError) {
        validationErrors.add(validationError);
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    @Override
    public String toString() {
        return "ValidationException{" +
            "validationErrors=" + validationErrors +
            '}';
    }
}
