package com.luxoft.ivko.validator;

import com.luxoft.ivko.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class ValidatorImpl implements UserValidator {

    @Override
    public void validateUserCredentials(String email, String password, boolean create) {
        if (StringUtils.isEmpty(email) || (create && StringUtils.isEmpty(password))) {
            throw new ValidationException("Invalid credentials: " + email);
        }
    }

    @Override
    public void validateUserEmail(String phone) {

    }

    @Override
    public void validateUserPhone(String phone) {

    }
}