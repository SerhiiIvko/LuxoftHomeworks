package com.luxoft.ivko.validator.impl;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.exception.ValidationException;
import com.luxoft.ivko.validator.ClientValidatorService;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ClientValidatorServiceImpl implements ClientValidatorService {

    @Override
    public boolean validateNewClientCredentials(String name, String password, String surname, String phone, String email, int age) {
        if (StringUtils.isEmpty(email) || (StringUtils.isEmpty(password)) || (StringUtils.isEmpty(phone))
                || !validateUserEmail(email) || !validateUserPhone(phone) || !validateAge(age)) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            return true;
        }
    }

    @Override
    public boolean validateModifiedClientCredentials(String name, String surname, String phone, String email) {
        if (StringUtils.isEmpty(name) || (StringUtils.isEmpty(surname))
                || validateUserEmail(email) || validateUserPhone(phone)) {
            throw new ValidationException(ConstantsContainer.VALIDATION_EXCEPTION_MESSAGE);
        } else {
            return true;
        }
    }

    private static boolean validateUserEmail(String email) {
        String pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        return (StringUtils.isEmpty(email) || Pattern.compile(pattern).matcher(email).matches());
    }

    private static boolean validateUserPhone(String phone) {
        String pattern = "^+((?:9[679]|8[035789]|6[789]|5[90]" +
                "|42|3[578]|2[1-689])|9[0-58]|8[1246]|6[0-6]|5" +
                "[1-8]|4[013-9]|3[0-469]|2[70]|7|1)(?:\\W*\\d){0,13}\\d$";
        return (StringUtils.isEmpty(phone) || Pattern.compile(pattern).matcher(phone).matches());
    }

    private static boolean validateAge(int age) {
        return age > 16 && age < 200;
    }
}