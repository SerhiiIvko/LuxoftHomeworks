package com.luxoft.ivko.validator.impl;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.exception.ValidationException;
import com.luxoft.ivko.validator.ClientValidatorService;
import com.luxoft.ivko.web.dto.ClientCreateDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.regex.Pattern;

@Repository
public class ClientValidatorServiceImpl implements ClientValidatorService {

    @Override
    public void validateClientCredentials(String name, String surname, String email, String password, String phone,
                                          String age, boolean create) {
        if (!(validateName(name)
                || validateSurname(surname)
                || validateEmail(email)
                || validatePassword(password)
                || validatePhone(phone)
                || validateAge(age))) {
            throw new ValidationException("Error! Invalid data!");
        }
    }

    @Override
    public void validateClient(ClientCreateDto createDto, boolean create) {
        validateClientCredentials(createDto.getName(), createDto.getSurname(), createDto.getEmail(),
                createDto.getPassword(), createDto.getPhone(), createDto.getAge(), create);
        if (StringUtils.isEmpty(createDto.getName())) {
            throw new ValidationException("Invalid client name: " + createDto.getName());
        }
    }

    private static boolean validateName(String name) {
        boolean correctName = !(name.trim().isEmpty() || name.length() > ConstantsContainer.MAX_INPUT_DATA_LENGTH);
        if (!correctName) {
            System.out.println("incorrect name " + name);
        }
        return correctName;
    }

    private static boolean validateSurname(String surname) {
        boolean correctSurname = !(surname.trim().isEmpty() || surname.length() > ConstantsContainer.MAX_INPUT_DATA_LENGTH);
        if (!correctSurname) {
            System.out.println("incorrect surname " + surname);
        }
        return correctSurname;
    }

    private static boolean validatePassword(String password) {
        boolean correctPasswordLength = password.length() > 6;
        boolean correctPassword = !(password.trim().isEmpty() || password.length()
                > ConstantsContainer.MAX_INPUT_DATA_LENGTH || !correctPasswordLength);
        if (correctPassword) {
            System.out.println("incorrect password");
        }
        return correctPassword;
    }

    private static boolean validateEmail(String email) {
        boolean correctEmail = !(email.trim().isEmpty() || email.length() > ConstantsContainer.MAX_INPUT_DATA_LENGTH);
        if (!correctEmail || !validateUserEmail(email)) {
            System.out.println("incorrect email " + email);
        }
        return (correctEmail && validateUserEmail(email));
    }

    private static boolean validatePhone(String phone) {
        boolean correctPhoneLength = (phone.length() == 13);
        boolean correctPhone = !phone.trim().isEmpty() && correctPhoneLength && validateUserPhone(phone);
        if (!correctPhone) {
            System.out.println("incorrect phone " + phone);
        }
        return (correctPhone);
    }

    private static boolean validateAge(String stringAge) {
        int age;
        if (stringAge.trim().isEmpty() || !stringAge.matches("\\d*")) {
            System.out.println("Age must be positive number!");
            return false;
        } else {
            age = Integer.parseInt(stringAge);
        }
        if (!(age > 16 && age < 200)) {
            System.out.println("Incorrect age " + stringAge);
        }
        return (age > 16 && age < 200);
    }

    private static boolean validateUserEmail(String email) {
        return (Pattern.compile(ConstantsContainer.EMAIL_VALIDATOR_PATTERN).matcher(email).matches());
    }

    private static boolean validateUserPhone(String phone) {
        return (Pattern.compile(ConstantsContainer.PHONE_VALIDATOR_PATTERN).matcher(phone).matches());
    }
}
