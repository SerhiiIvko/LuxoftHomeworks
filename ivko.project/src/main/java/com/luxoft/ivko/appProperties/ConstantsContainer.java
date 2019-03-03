package com.luxoft.ivko.appProperties;

import java.io.BufferedReader;
import java.io.IOException;

public class ConstantsContainer {
    public static final String MAIN_MENU =
            "1. Admin\n"
                    + "2. Client\n"
                    + "0. Exit";
    public static final String ADMIN_MENU =
            "1. Show all clients\n"
                    + "2. Modify client\n"
                    + "3. Remove client\n"
                    + "4. Show all products\n"
                    + "5. Add product\n"
                    + "6. Modify product\n"
                    + "7. Remove product\n"
                    + "8. Show orders by client ID\n"
                    + "9. Back to main menu\n"
                    + "0. Exit";
    public static final String CLIENT_MENU =
            "1. Register\n"
                    + "2. Enter for registered\n"
                    + "3. Edit credentials\n"
                    + "4. Remove account\n"
                    + "5. Show all products\n"
                    + "6. Add product in basket\n"
                    + "7. Remove product from basket\n"
                    + "8. Make order\n"
                    + "9. Pay order\n"
                    + "10. Cancel order\n"
                    + "11. Back to main menu\n"
                    + "0. Exit";
    public static final String SHOW_ADMIN_MENU = "Show admin menu";
    public static final String SHOW_CLIENT_MENU = "Show client menu";
    public static final String SHOW_EXIT_MESSAGE = "You successfully quit program";
    public static final String SHOW_DEFAULT_ERROR_MESSAGE = "Incorrect input";
    public static final String ADD_CLIENT_MESSAGE = "Add new client:";
    public static final String INPUT_CLIENT_NAME_MESSAGE = "Input client name";
    public static final String INPUT_CLIENT_SURNAME_MESSAGE = "Input client surname";
    public static final String INPUT_CLIENT_PHONE_MESSAGE = "Input client phone";
    public static final String INPUT_CLIENT_PASSWORD_MESSAGE = "Input client password";
    public static final String INPUT_CLIENT_EMAIL_MESSAGE = "Input client email";
    public static final String INPUT_CLIENT_AGE_MESSAGE = "Input client age";
    public static final String INPUT_CLIENT_ID_MESSAGE = "Input client id";
    public static final String MODIFY_CLIENT = "Modify client";
    public static final String MODIFY_CLIENT_NAME_MESSAGE = "Input new client name";
    public static final String MODIFY_CLIENT_SURNAME_MESSAGE = "Input new client surname";
    public static final String MODIFY_CLIENT_PHONE_MESSAGE = "Input new client phone";
    public static final String BACK_TO_MAIN_MENU = "Back to main menu";
    public static final String REMOVE_CLIENT = "Remove client";
    public static final String SHOW_ALL_CLIENTS = "Show all clients";
    public static final String SHOW_ALL_PRODUCTS = "Show all products";
    public static final String VALIDATION_EXCEPTION_MESSAGE = "Invalid credentials! Check input and try again!";
    public static final String EMPTY_LIST_EXCEPTION_MESSAGE = "Sorry, but list is empty!";


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String getStringFromConsole(BufferedReader reader) throws IOException {
        String string = "";
        while (string.equalsIgnoreCase("".trim())) {
            if (reader.read() < 0) {
                System.out.println("input string!");
                reader.readLine();
            } else {
                string = reader.readLine();
            }
        }
        return string;
    }

    public static Long readNumber(BufferedReader reader) throws IOException{
        long number = -1L;
        while (number < 0) {
            if (reader.read() < 1) {
                System.out.println("Input only natural positive digits!");
                reader.readLine();
            } else {
                number = Long.parseLong(reader.readLine());
                if (number < 0) {
                    System.out.println("Negative numbers are not allowed!");
                }
            }
        }
        return number;
    }
}
