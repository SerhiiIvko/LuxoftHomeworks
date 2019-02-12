package com.luxoft.ivko.view;

import com.luxoft.ivko.dao.appProperties.ConsoleOutputContainer;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ClientService clientService = new ClientServiceImpl();

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
                    clientService.createClient(name, surname, phone);
                    break;
                case "2":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.MODIFY_CLIENT);

                    break;
                case "3":
                    System.out.println("Remove client");
                    break;
                case "4":
                    System.out.println("List all clients");
                    break;
                case "0":
                    System.out.println("Exit");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }
}