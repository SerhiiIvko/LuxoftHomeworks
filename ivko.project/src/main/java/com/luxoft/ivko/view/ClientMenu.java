package com.luxoft.ivko.view;

import com.luxoft.ivko.dao.appProperties.ConsoleOutputContainer;
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
                case "0":
                    isRunning = false;
                    break;
                    default:
                        System.out.println("Incorrect input");
            }
        }
    }
}
