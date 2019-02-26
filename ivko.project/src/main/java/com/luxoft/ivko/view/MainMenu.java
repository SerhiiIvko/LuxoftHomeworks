package com.luxoft.ivko.view;

import com.luxoft.ivko.appProperties.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final AdminMenu adminMenu = new AdminMenu();
    private final ClientMenu clientMenu = new ClientMenu();

    public void showMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            ConstantsContainer.printMessage(ConstantsContainer.MAIN_MENU);
            switch (reader.readLine()) {
                case "1":
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_ADMIN_MENU);
                    adminMenu.show();
                    break;
                case "2":
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_CLIENT_MENU);
                    clientMenu.show();
                    break;
                case "0":
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_EXIT_MESSAGE);
                    isRunning = false;
                    break;
                default:
                    ConstantsContainer.printMessage(ConstantsContainer.SHOW_DEFAULT_ERROR_MESSAGE);
            }
        }
    }
}