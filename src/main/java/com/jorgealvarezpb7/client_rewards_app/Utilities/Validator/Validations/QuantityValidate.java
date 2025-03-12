package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class QuantityValidate implements ValidatorEval{
    private Integer min;
    private Integer max;

    public QuantityValidate(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void eval(String field, String value) throws ValidatorError {
        int number = this.parseNumber(field, value);

        if (number <= this.min) {
            throw new ValidatorError(field, "La cantidad tiene que ser mayor que " + this.min);
        } else if (number > this.max) {
            throw new ValidatorError(field, "La cantidad no puede ser mayor a " + this.max);
        }
    }

    private int parseNumber(String field, String value) throws ValidatorError {
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) {
            throw new ValidatorError(field, "Solo se admiten numeros.");
        }
    }
}