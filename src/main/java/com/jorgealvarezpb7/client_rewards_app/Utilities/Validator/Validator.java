package com.jorgealvarezpb7.client_rewards_app.Utilities.Validator;

import java.util.ArrayList;

import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations.EmailAdressValidate;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations.PhoneNumberValidate;
import com.jorgealvarezpb7.client_rewards_app.Utilities.Validator.Validations.ValidateRequired;

public class Validator {
    private ArrayList<ValidatorEval> validations;

    public Validator() {
        this.validations = new ArrayList<>();
    }

    public Validator isRequired() {
        this.validations.add(new ValidateRequired());
        return this;
    }

    public Validator isPhoneNumber() {
        this.validations.add(new PhoneNumberValidate());
        return this;
    }

    public Validator isEmailAdress() {
        this.validations.add(new EmailAdressValidate());
        return this;
    }

    public void validate(String field, String value) throws ValidatorError {
        for (ValidatorEval ve : this.validations) {
            ve.eval(field, value);
        }
    }
}
