package com.luxoft.ivko.appProperties;

public class ConsoleOutputContainer {
    public static final String MAIN_MENU =
            "1. Admin\n"
                    + "2. Client\n"
                    + "0. Exit";
    public static final String ADMIN_MENU =
            "1. Add client\n"
                    + "2. Modify client\n"
                    + "3. Remove client\n"
                    + "4. Show all clients\n"
                    + "5. Back to main menu\n"
                    + "0. Exit";
    public static final String CLIENT_MENU =
            "1. Show all products\n"
                    + "2. Add product in basket\n"
                    + "3. Remove product from basket\n"
                    + "4. Make order\n"
                    + "5. Pay order\n"
                    + "6. Back to main menu\n"
                    + "0. Exit";
    public static final String SHOW_ADMIN_MENU = "Show admin menu";
    public static final String SHOW_CLIENT_MENU = "Show client menu";
    public static final String SHOW_EXIT_MESSAGE = "You successfully quit program";
    public static final String SHOW_DEFAULT_ERROR_MESSAGE = "Incorrect input";
    public static final String ADD_CLIENT_MESSAGE = "Add new client:";
    public static final String INPUT_CLIENT_NAME_MESSAGE = "Input client name";
    public static final String INPUT_CLIENT_SURNAME_MESSAGE = "Input client surname";
    public static final String INPUT_CLIENT_PHONE_MESSAGE = "Input client phone";
    public static final String INPUT_CLIENT_ID_MESSAGE = "Input client id";
    public static final String MODIFY_CLIENT = "Modify client";
    public static final String MODIFY_CLIENT_NAME_MESSAGE = "Input new client name";
    public static final String MODIFY_CLIENT_SURNAME_MESSAGE = "Input new client surname";
    public static final String MODIFY_CLIENT_PHONE_MESSAGE = "Input new client phone";
    public static final String BACK_TO_MAIN_MENU = "Back to main menu";
    public static final String REMOVE_CLIENT = "Remove client";
    public static final String SHOW_ALL_CLIENTS = "Show all clients";
    public static final String SHOW_ALL_PRODUCTS = "Show all products";


    public static void printMessage(String message) {
        System.out.println(message);
    }
}
