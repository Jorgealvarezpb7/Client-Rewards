package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class PhoneNumberValidate implements ValidatorEval{
    @Override
    public void eval(String field, String value) throws ValidatorError {
        
        if (!value.startsWith("+")) {
            throw new ValidatorError(field, "El codigo de area es obligatorio.");
        }
        if (value.contains(" ")) {
            throw new ValidatorError(field, "No se admiten espacios.");
        }
        
        String numericPart = value.substring(1);

        try {
            Integer.parseInt(numericPart);
        } catch (Exception ex) {
            throw new ValidatorError(field, "Solo se admiten numeros despues del \"+\"");
        }
    }
    
} 
