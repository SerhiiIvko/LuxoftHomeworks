package com.luxoft.ivko.validator;

public interface UserValidator {

    /**
     * Validate main user credentials
     *
     * @param email validation String user email, if it is empty
     * @param password validation String user password, if it is empty
     */
    void validateUserCredentials(String email, String password, boolean create);

    /**
     * Validate main user credentials
     *
     * @param email validation String user email, if it is empty
     */
    void validateUserEmail(String email);

    /**
     * Validate main user credentials
     *
     * @param phone validation String user email, if it is empty
     */
    void validateUserPhone(String phone);
}