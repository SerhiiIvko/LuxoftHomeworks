package com.luxoft.ivko.validator;

import com.luxoft.ivko.web.dto.ClientCreateDto;

public interface ClientValidatorService {

    void validateClientCredentials(String name, String surname, String email, String password, String phone,
                                   String age, boolean create);

    void validateClient(ClientCreateDto createDto, boolean create);
}