package com.luxoft.ivko.view;

import com.luxoft.ivko.appProperties.*;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class AdminMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ClientService clientService = new ClientServiceImpl();
    private Client client;

    public void show() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            ConstantsContainer.printMessage(ConstantsContainer.ADMIN_MENU);
            switch (reader.readLine()) {
                case "1":
//                    ConstantsContainer.printMessage(ConstantsContainer.ADD_CLIENT_MESSAGE);
//                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_NAME_MESSAGE);
//                    String name = reader.readLine();
//                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_SURNAME_MESSAGE);
//                    String surname = reader.readLine();
//                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_SURNAME_MESSAGE);
//                    String email = reader.readLine();
//                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_SURNAME_MESSAGE);
//                    String password = reader.readLine();
//                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_PHONE_MESSAGE);
//                    String phone = reader.readLine();
//                    client = clientService.createClient(name, surname, phone);
                    break;
                case "2":
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT);
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT_NAME_MESSAGE);
                    String newName = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT_SURNAME_MESSAGE);
                    String newSurname = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT_PHONE_MESSAGE);
                    String newPhone = reader.readLine();
                    clientService.modifyClient(client, newName, newSurname, newPhone);
                    break;
                case "3":
                    ConstantsContainer.printMessage(ConstantsContainer.REMOVE_CLIENT);
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_ID_MESSAGE);
                    BigDecimal id = new BigDecimal(reader.readLine());
                    clientService.deleteClient(id);
                    break;
                case "4":
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_ALL_CLIENTS);
                    clientService.showAllClients();
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
                    ConstantsContainer.printMessage(ConstantsContainer.BACK_TO_MAIN_MENU);
                    isRunning = false;
                    break;
                case "0":
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_EXIT_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_DEFAULT_ERROR_MESSAGE);
            }
        }
    }
}