package com.luxoft.ivko.appProperties;

import java.util.Scanner;

public class AppUtilMethods {
    public static void printMessage(String message) {
        System.out.println(message);
    }
//
//    public static String getStringFromConsole(Scanner scanner, String inviteText) {
//        String string = "";
//        AppUtilMethods.printMessage(inviteText);
//        while (string.equalsIgnoreCase("")) {
//            if (!scanner.hasNext()) {
//                AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
//                scanner.nextLine();
//            } else {
//                string = scanner.nextLine();
//            }
//        }
//        return string.toLowerCase().trim();
//    }
}
