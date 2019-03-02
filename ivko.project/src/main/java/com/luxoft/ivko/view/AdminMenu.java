package com.luxoft.ivko.view;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_ALL_CLIENTS);
                    clientService.showAllClients();
                    break;
                case "2":
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT);
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT_NAME_MESSAGE);
                    String newName = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT_SURNAME_MESSAGE);
                    String newSurname = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.MODIFY_CLIENT_PHONE_MESSAGE);
                    String newPhone = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_EMAIL_MESSAGE);
                    String newEmail = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_PASSWORD_MESSAGE);
                    String newPassword = reader.readLine();
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_AGE_MESSAGE);
                    String newAge = reader.readLine();
                    clientService.modifyClient(client, newName, newSurname, newEmail, newPassword, newPhone, newAge);
                    break;
                case "3":
                    ConstantsContainer.printMessage(ConstantsContainer.REMOVE_CLIENT);
                    ConstantsContainer.printMessage(ConstantsContainer.INPUT_CLIENT_ID_MESSAGE);
                    Long id = ConstantsContainer.readNumber(reader);
                    clientService.deleteClient(id);
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
