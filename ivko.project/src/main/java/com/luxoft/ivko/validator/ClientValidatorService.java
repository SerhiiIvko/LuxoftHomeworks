package com.luxoft.ivko.validator;

public interface ClientValidatorService {

    /**
     * Validate main user credentials
     *
     * @param name    validation String user name, if it is empty
     * @param surname validation String user surname, if it is empty
     * @param phone    validation String user phone number, if it is't correct
     * @param email    validation String user email, if it is empty or isn't correct
     * @param password    validation String user password, if it is empty
     * @param age    validation int user age, if it is't correct
     */
    boolean validateNewClientCredentials(String name, String password, String surname, String phone, String email, int age);

    /**
     * Validate main user credentials
     *
     * @param name    validation String user name, if it is empty or isn't correct
     * @param surname validation String user surname, if it is empty
     * @param phone    validation String user phone number, if it is't correct
     * @param email    validation String user email, if it is empty or isn't correct
     */
    boolean validateModifiedClientCredentials(String name, String surname, String phone, String email);
}