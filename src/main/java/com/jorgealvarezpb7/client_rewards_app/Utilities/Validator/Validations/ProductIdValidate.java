package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class ProductIdValidate implements ValidatorEval {
    @Override
    public void eval(String field, String value) throws ValidatorError {

        if (!value.startsWith("P") ) {
            throw new ValidatorError(field, "El Id debe empezar con 'P'.");
        }

        if (value.length() != 4) {
            throw new ValidatorError(field, "El Id debe tener 1 letra + 3 numeros");
        }

        if(!value.substring(1).matches("[0-9]*")){
            throw new ValidatorError(field, "El Id debe tener 1 letra + 3 numeros.");
        }
    }
}

    

