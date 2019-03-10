package com.luxoft.ivko.appProperties;

public class ClientMenuConstants {
    public static final String CLIENT_MENU =
            "1. Register\n"
                    + "2. Enter for registered\n"
                    + "3. Show all products\n"
                    + "4. Add product in basket\n"
                    + "5. Remove product from basket\n"
                    + "6. Go to basket\n"
                    + "7. Back to main menu\n"
                    + "0. Exit";
    public static final String CLIENT_MANIPULATION_MENU = AdminMenuConstants.CLIENT_MANIPULATION_MENU;
    public static final String ORDER_MANIPULATION_MENU =
            "1. Make order\n"
                    + "2. Pay order\n"
                    + "3. Cancel order\n"
                    + "4. Back to main menu\n"
                    + "0. Exit";
    public static final String ADD_CLIENT_MESSAGE = "Add new client:";
    public static final String INPUT_CLIENT_ID_MESSAGE = "Input client id";
    public static final String INPUT_CLIENT_NAME_MESSAGE = "Input client name";
    public static final String INPUT_CLIENT_SURNAME_MESSAGE = "Input client surname";
    public static final String INPUT_CLIENT_EMAIL_MESSAGE = "Input client email";
    public static final String INPUT_CLIENT_PASSWORD_MESSAGE = "Input client password";
    public static final String INPUT_CLIENT_PHONE_MESSAGE = "Input client phone";
    public static final String INPUT_CLIENT_AGE_MESSAGE = "Input client age";
    public static final String MODIFY_CLIENT = "Modify client";
    public static final String MODIFY_CLIENT_NAME_MESSAGE = "Input new client name";
    public static final String MODIFY_CLIENT_SURNAME_MESSAGE = "Input new client surname";
    public static final String MODIFY_CLIENT_PHONE_MESSAGE = "Input new client phone";
    public static final String SHOW_ALL_PRODUCTS = AdminMenuConstants.SHOW_ALL_PRODUCTS;
    public static final String ADD_PRODUCT_MESSAGE = "Add new product into basket:";
    public static final String REMOVE_PRODUCT_MESSAGE = "Remove product from basket, input product ID:";
    public static final String FAILED_TO_LOAD_CLIENT_FROM_DB = "Failed to load client from DB";
    public static final String FAILED_TO_INSERT_CLIENT_INTO_DB = "Failed to insert client into DB";
    public static final String FAILED_TO_UPDATE_CLIENT = "Failed to update client";
    public static final String FAILED_TO_DELETE_CLIENT = "Failed to delete client";

}
