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
            ConsoleOutputContainer.printMessage(ConsoleOutputContainer.ADMIN_MENU);
            switch (reader.readLine()) {
                case "1":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.ADD_CLIENT_MESSAGE);
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.INPUT_CLIENT_NAME_MESSAGE);
                    String name = reader.readLine();
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.INPUT_CLIENT_SURNAME_MESSAGE);
                    String surname = reader.readLine();
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.INPUT_CLIENT_PHONE_MESSAGE);
                    String phone = reader.readLine();
                    client = clientService.createClient(name, surname, phone);
                    break;
                case "2":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.MODIFY_CLIENT);
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.MODIFY_CLIENT_NAME_MESSAGE);
                    String newName = reader.readLine();
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.MODIFY_CLIENT_SURNAME_MESSAGE);
                    String newSurname = reader.readLine();
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.MODIFY_CLIENT_PHONE_MESSAGE);
                    String newPhone = reader.readLine();
                    clientService.modifyClient(client, newName, newSurname, newPhone);
                    break;
                case "3":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.REMOVE_CLIENT);
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.INPUT_CLIENT_ID_MESSAGE);
                    BigDecimal id = new BigDecimal(reader.readLine());
                    clientService.deleteClient(id);
                    break;
                case "4":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_ALL_CLIENTS);
                    clientService.showAllClients();
                    break;
                case "5":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.BACK_TO_MAIN_MENU);
                    isRunning = false;
                    break;
                case "0":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_EXIT_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_DEFAULT_ERROR_MESSAGE);
            }
        }
    }
}