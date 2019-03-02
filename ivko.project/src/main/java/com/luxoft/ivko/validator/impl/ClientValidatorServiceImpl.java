package com.luxoft.ivko.validator.impl;

import com.luxoft.ivko.validator.ClientValidatorService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidatorServiceImpl implements ClientValidatorService {
    private final int maxInputDataLength = 28;

    @Override
    public boolean validateName(String name) {
        boolean correctName = !(name.trim().isEmpty() || name.length() > maxInputDataLength);
        if (!correctName) {
            System.out.println("incorrect name " + name);
        }
        return correctName;
    }

    @Override
    public boolean validateSurname(String surname) {
        boolean correctSurname = !(surname.trim().isEmpty() || surname.length() > maxInputDataLength);
        if (!correctSurname) {
            System.out.println("incorrect surname " + surname);
        }
        return correctSurname;
    }

    @Override
    public boolean validatePassword(String password) {
        boolean correctPasswordLength = password.length() > 6;
        boolean correctPassword = !(password.trim().isEmpty() || password.length() > maxInputDataLength || !correctPasswordLength);
        if (correctPassword) {
            System.out.println("incorrect password");
        }
        return correctPassword;
    }

    @Override
    public boolean validateEmail(String email) {
        boolean correctEmail = !(email.trim().isEmpty() || email.length() > maxInputDataLength);
        if (!correctEmail || !validateUserEmail(email)) {
            System.out.println("incorrect email " + email);
        }
        return (correctEmail && validateUserEmail(email));
    }

    @Override
    public boolean validatePhone(String phone) {
        boolean correctPhoneLength = (phone.length() == 13);
        boolean correctPhone = !phone.trim().isEmpty() && correctPhoneLength && validateUserPhone(phone);
        if (!correctPhone) {
            System.out.println("incorrect phone " + phone);
        }
        return (correctPhone);
    }

    @Override
    public boolean validateAge(String stringAge) {
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
        String pattern = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        return (Pattern.compile(pattern).matcher(email).matches());
    }

    private static boolean validateUserPhone(String phone) {
        Pattern pattern = Pattern
                .compile("^(?:[+][0-9]{2}\\s?[0-9]{3}[-]?[0-9]{3,}|(?:[(][0-9]{3}[)]|" +
                        "[0-9]{3})\\s*[-]?\\s*[0-9]{3}[-][0-9]{4})(?:\\s*x\\s*[0-9]+)?");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
