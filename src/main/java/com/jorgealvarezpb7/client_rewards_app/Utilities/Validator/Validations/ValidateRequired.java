package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class ValidateRequired implements ValidatorEval {
    @Override
    public void eval(String field, String value) throws ValidatorError {
        if (value == null || value.isEmpty()) {
            throw new ValidatorError(field, "El campo es obligatorio.");
        }
    }
}
