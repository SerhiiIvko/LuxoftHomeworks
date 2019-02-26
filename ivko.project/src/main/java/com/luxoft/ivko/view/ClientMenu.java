package com.luxoft.ivko.view;

import com.luxoft.ivko.appProperties.*;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ClientService clientService = new ClientServiceImpl();
    private Client client;

    public void show() throws IOException {
        boolean isRunning = true;
        ConstantsContainer.printMessage(ConstantsContainer.CLIENT_MENU);
        while (isRunning) {
            switch (reader.readLine()) {
                case "1":
                    ConstantsContainer.printMessage(ConstantsContainer.ADD_CLIENT_MESSAGE);
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_NAME_MESSAGE);
                    String name = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_SURNAME_MESSAGE);
                    String surname = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_SURNAME_MESSAGE);
                    String email = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_SURNAME_MESSAGE);
                    String password = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_PHONE_MESSAGE);
                    String phone = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_PHONE_MESSAGE);
                    int age = Integer.parseInt(reader.readLine());
                    client = clientService.createClient(name, surname, email, password, phone, age);
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;
                case "10":

                    break;
                case "11":
                    ConstantsContainer.printMessage(ConstantsContainer.BACK_TO_MAIN_MENU);
                    isRunning = false;
                    break;
                case "0":
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_EXIT_MESSAGE);
                    System.exit(0);
                default:
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_DEFAULT_ERROR_MESSAGE);
            }
        }
    }
}
