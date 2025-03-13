package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class IdValidate implements ValidatorEval {
    @Override
    public void eval(String field, String value) throws ValidatorError {
        
        if (!value.startsWith("#")) {
            throw new ValidatorError(field, "El id debe empezar con '#'");
        }

        if (value.length() != 6) {
            throw new ValidatorError(field, "El ID debe tener '#' + 2 letras + 3 numeros");
        }

        if(!value.substring(1, 2).matches("[A-Z]*")){
            throw new ValidatorError(field, "El ID debe tener '#' + 2 letras + 3 numeros");
        }

        if(!value.substring(3).matches("[0-9]*")){
            throw new ValidatorError(field, "El ID debe tener '#' + 2 letras + 3 numeros");
        }
    }
}

    

