package com.luxoft.ivko.dao.appProperties;

public class ConsoleOutputContainer {
    public static final String MAIN_MENU =
                      "1. Admin\n"
                    + "2. Client\n"
                    + "3. Exit";
    public static final String ADMIN_MENU =
              "1. Add client\n"
            + "2. Modify client\n"
            + "3. Remove client\n"
            + "4. List all clients\n"
            + "0. Exit";
    public static final String CLIENT_MENU =
              "1. Add product in basket\n"
            + "2. Remove product from basket\n"
            + "3. Make order\n"
            + "4. Pay order\n"
            + "0. Exit";
    public static final String SHOW_ADMIN_MENU = "Show admin menu";
    public static final String SHOW_CLIENT_MENU = "Show client menu";
    public static final String SHOW_EXIT_MESSAGE = "You successfully quit program";
    public static final String SHOW_DEFAULT_ERROR_MESSAGE = "Incorrect input";
    public static final String ADD_CLIENT_MESSAGE = "Add new client:";
    public static final String INPUT_CLIENT_NAME_MESSAGE = "Input client name";
    public static final String INPUT_CLIENT_SURNAME_MESSAGE = "Input client surname";
    public static final String INPUT_CLIENT_PHONE_MESSAGE = "Input client phone";
    public static final String MODIFY_CLIENT = "Modify client";
    public static final String MODIFY_CLIENT_NAME_MESSAGE = "Input new client name";
    public static final String MODIFY_CLIENT_SURNAME_MESSAGE = "Input new client surname";
    public static final String MODIFY_CLIENT_PHONE_MESSAGE = "Input new client phone";

    public static void printMessage(String message){
        System.out.println(message);
    }
}