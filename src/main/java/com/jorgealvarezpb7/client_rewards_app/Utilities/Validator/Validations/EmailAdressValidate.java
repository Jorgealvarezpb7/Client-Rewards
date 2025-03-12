package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorError;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.ValidatorEval;

public class EmailAdressValidate implements ValidatorEval {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void eval(String field, String value) throws ValidatorError {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(value);

        if (matcher.matches()) {
            return;
        }
        throw new ValidatorError(field, "El email no es valido.");
    }
   
}
