package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class ClientIdValidate implements ValidatorEval {
    @Override
    public void eval(String field, String value) throws ValidatorError {

        if (!value.startsWith("C") ) {
            throw new ValidatorError(field, "El Id debe empezar con 'C'.");
        }

        if (value.length() != 4) {
            throw new ValidatorError(field, "El Id debe tener 1 letra + 3 numeros.");
        }

        if(!value.substring(1).matches("[0-9]*")){
            throw new ValidatorError(field, "El Id debe tener 1 letra + 3 numeros.");
        }
    }
}

    

