package com.luxoft.ivko.validator;

public interface ClientValidatorService {

    /**
     * Validate main user credentials
     *
     * @param name validation String user name
     */
    boolean validateName(String name);


    /**
     * Validate main user credentials
     *
     * @param surname validation String user surname
     */
    boolean validateSurname(String surname);


    /**
     * Validate main user credentials
     *
     * @param password validation String user password
     */
    boolean validatePassword(String password);

    /**
     * Validate main user credentials
     *
     * @param email validation String user email
     */
    boolean validateEmail(String email);


    /**
     * Validate main user credentials
     *
     * @param phone validation String user phone number
     */
    boolean validatePhone(String phone);


    /**
     * Validate main user credentials
     *
     * @param age validation int user age
     */
    boolean validateAge(String age);
}
