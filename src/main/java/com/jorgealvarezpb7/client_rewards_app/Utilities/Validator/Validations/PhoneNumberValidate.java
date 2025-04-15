package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class PhoneNumberValidate implements ValidatorEval{
    @Override
    public void eval(String field, String value) throws ValidatorError {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidatorError(field, "El número no puede estar vacío.");
        }

        String sanitized = value.replaceAll("\\s+", "");

        if (!sanitized.startsWith("+")) {
            throw new ValidatorError(field, "El código de área es obligatorio (debe comenzar con '+').");
        }

        String numericPart = sanitized.substring(1);

        if (!numericPart.matches("\\d+")) {
            throw new ValidatorError(field, "Solo se admiten números después del '+'.");
        }

        if (numericPart.length() < 8 || numericPart.length() > 15) {
            throw new ValidatorError(field, "El número debe tener entre 8 y 15 dígitos.");
        }
    }
    
} 
