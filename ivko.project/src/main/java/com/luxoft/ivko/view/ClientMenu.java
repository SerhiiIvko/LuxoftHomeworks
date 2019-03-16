//package com.luxoft.ivko.view;
//
//import com.luxoft.ivko.appProperties.AppUtilMethods;
//import com.luxoft.ivko.appProperties.ClientMenuConstants;
//import com.luxoft.ivko.appProperties.ConstantsContainer;
//import com.luxoft.ivko.domain.Client;
//import com.luxoft.ivko.service.ClientService;
//import com.luxoft.ivko.service.impl.ClientServiceImpl;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class ClientMenu {
//    private final Scanner scanner = new Scanner(System.in);
//    private final ClientService clientService = new ClientServiceImpl();
//    private Client client;
//
//    public void show() throws IOException {
//        boolean isRunning = true;
//        AppUtilMethods.printMessage(ClientMenuConstants.CLIENT_MENU);
//        String input = scanner.nextLine();
//        while (isRunning) {
//            switch (input) {
//                case "1":
//                    registerNewClient();
//                    isRunning = false;
//                    break;
//                case "2":
//                    AppUtilMethods.printMessage(ClientMenuConstants.CLIENT_MANIPULATION_MENU);
//                    break;
//                case "3":
//                    AppUtilMethods.printMessage(ClientMenuConstants.SHOW_ALL_PRODUCTS);
//                    break;
//                case "4":
//                    AppUtilMethods.printMessage(ClientMenuConstants.ADD_PRODUCT_MESSAGE);
//                    break;
//                case "5":
//                    AppUtilMethods.printMessage(ClientMenuConstants.FAILED_TO_DELETE_CLIENT);
//                    break;
//                case "6":
//                    AppUtilMethods.printMessage(ClientMenuConstants.ORDER_MANIPULATION_MENU);
//                    break;
//                case "7":
//                    AppUtilMethods.printMessage(ConstantsContainer.BACK_TO_MAIN_MENU);
//                    isRunning = false;
//                    break;
//                case "0":
//                    AppUtilMethods.printMessage(ConstantsContainer.EXIT_MESSAGE);
//                    System.exit(0);
//                default:
//                    AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
//            }
//        }
//    }
//
//    private void registerNewClient() throws IOException {
//        AppUtilMethods.printMessage(ClientMenuConstants.ADD_CLIENT_MESSAGE);
//        String name = AppUtilMethods.getStringFromConsole(scanner, ClientMenuConstants.INPUT_CLIENT_NAME_MESSAGE);
//        String surname = AppUtilMethods.getStringFromConsole(scanner, ClientMenuConstants.INPUT_CLIENT_SURNAME_MESSAGE);
//        String email = AppUtilMethods.getStringFromConsole(scanner, ClientMenuConstants.INPUT_CLIENT_EMAIL_MESSAGE);
//        String password = AppUtilMethods.getStringFromConsole(scanner, ClientMenuConstants.INPUT_CLIENT_PASSWORD_MESSAGE);
//        String phone = AppUtilMethods.getStringFromConsole(scanner, ClientMenuConstants.INPUT_CLIENT_PHONE_MESSAGE);
//        String age = AppUtilMethods.getStringFromConsole(scanner, ClientMenuConstants.INPUT_CLIENT_AGE_MESSAGE);
//        client = new Client(name, surname, email, password, phone, age);
//        clientService.createClient(client);
//
//    }
//}
