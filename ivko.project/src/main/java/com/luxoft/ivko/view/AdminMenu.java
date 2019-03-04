package com.luxoft.ivko.view;

import com.luxoft.ivko.appProperties.AdminMenuConstants;
import com.luxoft.ivko.appProperties.AppUtilMethods;
import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.dao.ClientDao;
import com.luxoft.ivko.dao.impl.ClientDaoDBImpl;
import com.luxoft.ivko.domain.Client;
import com.luxoft.ivko.service.ClientService;
import com.luxoft.ivko.service.ProductService;
import com.luxoft.ivko.service.impl.ClientServiceImpl;
import com.luxoft.ivko.service.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AdminMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final ClientService clientService = new ClientServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
//    private Client client;

    public void showMainAdminMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            AppUtilMethods.printMessage(AdminMenuConstants.ADMIN_MENU);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    AppUtilMethods.printMessage(AdminMenuConstants.SHOW_ALL_CLIENTS);
                    showAllClients();
                    showClientManipulationMenu();
                    break;
                case "2":
                    AppUtilMethods.printMessage(AdminMenuConstants.SHOW_ALL_PRODUCTS);
                    showProductManipulationMenu();
                    break;
                case "3":
                    AppUtilMethods.printMessage(AdminMenuConstants.SHOW_ORDER_BY_CLIENT_ID_MESSAGE);

                    break;
                case "4":
                    AppUtilMethods.printMessage(ConstantsContainer.BACK_TO_MAIN_MENU);
                    isRunning = false;
                    break;
                case "0":
                    AppUtilMethods.printMessage(ConstantsContainer.EXIT_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
            }
        }
    }

    public void showClientManipulationMenu()throws IOException{
        boolean isRunning = true;
        while (isRunning) {
            AppUtilMethods.printMessage(AdminMenuConstants.CLIENT_MANIPULATION_MENU);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    AppUtilMethods.printMessage(AdminMenuConstants.MODIFY_CLIENT);
                    modifyClient();
                    break;
                case "2":
                    AppUtilMethods.printMessage(AdminMenuConstants.REMOVE_CLIENT);
                    removeClient();
                    break;
                case "3":
                    AppUtilMethods.printMessage(ConstantsContainer.BACK_TO_MAIN_MENU);
                    isRunning = false;
                    break;
                case "0":
                    AppUtilMethods.printMessage(ConstantsContainer.EXIT_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
            }
        }
    }

    public void showProductManipulationMenu()throws IOException{
        boolean isRunning = true;
        while (isRunning) {
            AppUtilMethods.printMessage(AdminMenuConstants.PRODUCT_MANIPULATION_MENU);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    AppUtilMethods.printMessage(AdminMenuConstants.ADD_PRODUCT_MESSAGE);
                    addProduct();
                    break;
                case "2":
//                    modifyClient();
                    break;
                case "3":
//                    removeClient();
                    break;
                case "4":
                    AppUtilMethods.printMessage(ConstantsContainer.BACK_TO_MAIN_MENU);
                    isRunning = false;
                    break;
                case "0":
                    AppUtilMethods.printMessage(ConstantsContainer.EXIT_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    AppUtilMethods.printMessage(ConstantsContainer.DEFAULT_ERROR_MESSAGE);
            }
        }
    }

    private void removeClient() throws IOException {
        AppUtilMethods.printMessage(AdminMenuConstants.REMOVE_CLIENT);
        Long id = AppUtilMethods.readNumber(scanner, AdminMenuConstants.INPUT_CLIENT_ID_MESSAGE);
        clientService.deleteClient(id);
    }

    private void modifyClient() throws IOException {
        AppUtilMethods.printMessage(AdminMenuConstants.MODIFY_CLIENT);
        Long id = AppUtilMethods.readNumber(scanner, AdminMenuConstants.INPUT_CLIENT_ID_MESSAGE);
        String newName = AppUtilMethods.getStringFromConsole(scanner, AdminMenuConstants.MODIFY_CLIENT_NAME_MESSAGE);
        String newSurname = AppUtilMethods.getStringFromConsole(scanner, AdminMenuConstants.MODIFY_CLIENT_SURNAME_MESSAGE);
        String newPhone = AppUtilMethods.getStringFromConsole(scanner, AdminMenuConstants.MODIFY_CLIENT_PHONE_MESSAGE);
        String newEmail = AppUtilMethods.getStringFromConsole(scanner, AdminMenuConstants.INPUT_CLIENT_EMAIL_MESSAGE);
        String newPassword = AppUtilMethods.getStringFromConsole(scanner, AdminMenuConstants.INPUT_CLIENT_PASSWORD_MESSAGE);
        String newAge = AppUtilMethods.getStringFromConsole(scanner,AdminMenuConstants.INPUT_CLIENT_AGE_MESSAGE );
        ClientDao clientDao = new ClientDaoDBImpl();
        Client client = clientDao.getClientById(id);
        clientService.modifyClient(client, newName, newSurname, newEmail, newPassword, newPhone, newAge);
    }

    private void showAllClients() {
        AppUtilMethods.printMessage(AdminMenuConstants.SHOW_ALL_CLIENTS);
        clientService.showAllClients();
    }

    private void addProduct(){

    }
}
