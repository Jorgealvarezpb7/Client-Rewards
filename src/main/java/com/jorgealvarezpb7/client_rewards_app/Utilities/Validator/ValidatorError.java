package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator;

public class ValidatorError extends Exception {
    private String field;
    private String message;

    public ValidatorError(String field, String message) {
        super("ValidatorError(" + field + "): " + message);
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
