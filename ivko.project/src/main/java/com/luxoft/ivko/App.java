package com.luxoft.ivko;

import com.luxoft.ivko.dao.impl.DBManager;
import com.luxoft.ivko.validator.ClientValidatorService;
import com.luxoft.ivko.validator.impl.ClientValidatorServiceImpl;
import com.luxoft.ivko.view.MainMenu;

import javax.sql.DataSource;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        DataSource dataSource = null;
        dataSource = DBManager.getH2DataSource();

        try {
            DBManager.initialize(dataSource);
            mainMenu.showMenu();
            DBManager.stopDb();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
