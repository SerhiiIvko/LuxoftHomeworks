package com.luxoft.ivko.appProperties;

import java.util.Scanner;

public class AppUtilMethods {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String getStringFromConsole(Scanner scanner, String inviteText) {
        String string = "";
        AppUtilMethods.printMessage(inviteText);
        while (string.equalsIgnoreCase("")) {
            if (!scanner.hasNext()) {
                AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
                scanner.nextLine();
            } else {
                string = scanner.nextLine();
            }
//            if (!string.equalsIgnoreCase(ConsoleMessages.USER_ANSWER_NO_1)
//                    && !string.equalsIgnoreCase(ConsoleMessages.USER_ANSWER_NO_2)
//                    && !string.equalsIgnoreCase(ConsoleMessages.USER_ANSWER_YES_1)
//                    && !string.equalsIgnoreCase(ConsoleMessages.USER_ANSWER_YES_2)) {
//                string = "";
//                ConsoleMessages.printMessage(ConsoleMessages.WARN_MESSAGE);
//            }
        }
        return string.toLowerCase().trim();
    }

    public static Long readNumber(Scanner scanner, String inviteText) {
        long number = -1L;
        System.out.println(inviteText);
        while (number < 0) {
            if (!scanner.hasNextInt()) {
                System.out.println("Input only natural positive digits!");
                scanner.next();
            } else {
                number = scanner.nextLong();
                if (number < 0) {
                    System.out.println("Negative numbers are not allowed!");
                }
            }
        }
        return number;
    }
}
