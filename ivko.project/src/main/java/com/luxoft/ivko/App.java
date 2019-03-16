//package com.luxoft.ivko;
//
//import com.luxoft.ivko.dao.impl.DBManager;
//import com.luxoft.ivko.view.MainMenu;
//
//import java.io.IOException;
//
//public class App {
//    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        try {
//            DBManager.initialize(DBManager.getH2DataSource());
//            mainMenu.showMenu();
//            DBManager.stopDb();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
