//package com.luxoft.ivko.view;
//
//import com.luxoft.ivko.appProperties.AppUtilMethods;
//import com.luxoft.ivko.appProperties.ConstantsContainer;
//import com.luxoft.ivko.appProperties.MainMenuConstants;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class MainMenu {
//    private final Scanner scanner = new Scanner(System.in);
//    private final AdminMenu adminMenu = new AdminMenu();
//    private final ClientMenu clientMenu = new ClientMenu();
//
//    public void showMenu() throws IOException {
//        boolean isRunning = true;
//        while (isRunning) {
//            AppUtilMethods.printMessage(MainMenuConstants.MAIN_MENU);
//            String input = scanner.nextLine();
//            switch (input) {
//                case "1":
//                    AppUtilMethods.printMessage(MainMenuConstants.SHOW_ADMIN_MENU);
//                    adminMenu.showMainAdminMenu();
//                    break;
//                case "2":
//                    AppUtilMethods.printMessage(MainMenuConstants.SHOW_CLIENT_MENU);
//                    clientMenu.show();
//                    break;
//                case "0":
//                    AppUtilMethods.printMessage(ConstantsContainer.EXIT_MESSAGE);
//                    isRunning = false;
//                    break;
//                default:
//                    AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
//            }
//        }
//    }
//}