package com.luxoft.ivko;

import com.luxoft.ivko.view.MainMenu;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.showMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}