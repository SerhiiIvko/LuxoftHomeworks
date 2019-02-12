package com.luxoft.ivko.view;

import com.luxoft.ivko.dao.appProperties.ConsoleOutputContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final AdminMenu adminMenu = new AdminMenu();
    private final ClientMenu clientMenu = new ClientMenu();

    public void showMenu() throws IOException {
        boolean isRunning = true;
        while  (isRunning) {
            ConsoleOutputContainer.printMessage(ConsoleOutputContainer.MAIN_MENU);
            switch (reader.readLine()) {
                case "1":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_ADMIN_MENU);
                    adminMenu.show();
                    break;
                case "2":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_CLIENT_MENU);
                    clientMenu.show();
                    break;
                case "0":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_EXIT_MESSAGE);
                    isRunning = false;
                    break;
                default:
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_DEFAULT_ERROR_MESSAGE);
            }
        }
    }
}