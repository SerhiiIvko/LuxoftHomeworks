package com.luxoft.ivko.view;

import com.luxoft.ivko.appProperties.ConsoleOutputContainer;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMenu {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ClientService clientService = new ClientServiceImpl();

    public void show() throws IOException {
        boolean isRunning = true;
        ConsoleOutputContainer.printMessage(ConsoleOutputContainer.CLIENT_MENU);
        while (isRunning){
            switch (reader.readLine()){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.BACK_TO_MAIN_MENU);
                    isRunning=false;
                    break;
                case "0":
                    ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_EXIT_MESSAGE);
                    System.exit(0);
                    default:
                        ConsoleOutputContainer.printMessage(ConsoleOutputContainer.SHOW_DEFAULT_ERROR_MESSAGE);
            }
        }
    }
}
