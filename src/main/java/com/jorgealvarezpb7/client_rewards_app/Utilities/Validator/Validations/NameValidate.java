package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class NameValidate implements ValidatorEval {
    @Override
    public void eval(String field, String value) throws ValidatorError {
        
        if(!value.substring(0).matches("[a-zA-Z]*")){
            throw new ValidatorError(field, "Solo se admiten letras");
        }
    }
}

    

