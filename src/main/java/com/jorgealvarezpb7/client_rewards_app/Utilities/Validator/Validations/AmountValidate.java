package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class AmountValidate implements ValidatorEval {
  @Override
    public void eval(String field, String value) throws ValidatorError {

        if(value.contains(" ")) {
            throw new ValidatorError(field, "No se admiten espacios.");
        }

        if(value.contains(",")) {
            throw new ValidatorError(field, "No se admiten ',' para decimales.");
        }

        if(value.substring(0).matches("[a-zA-Z]*")) {
            throw new ValidatorError(field, "No se admiten letras.");
        }
    }
}
