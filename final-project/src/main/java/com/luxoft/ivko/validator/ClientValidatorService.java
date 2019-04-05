package com.luxoft.ivko.validator;

import com.luxoft.ivko.web.dto.ClientCreateDto;

public interface ClientValidatorService {

    /**
     * Validate main client data
     *
     * @param name     validation String client name
     * @param surname  validation String client surname
     * @param email    validation String client email
     * @param password validation String client password
     * @param phone    validation String client phone
     * @param age      validation String client age
     * @param create   validation condition client create
     */
    void validateClientCredentials(String name, String surname, String email, String password, String phone,
                                   String age, boolean create);

    /**
     * Validate main client data
     *
     * @param createDto validation ClientCreateDto object
     * @param create    validation condition object create
     */
    void validateClient(ClientCreateDto createDto, boolean create);
}