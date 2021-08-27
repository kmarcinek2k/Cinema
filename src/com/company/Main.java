package com.company;

import com.company.Users.Person;
import com.company.Users.User;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> users = new LinkedList();
        BazaDanych baza = BazaDanych.getInstance();
        users = baza.DownloadDatabase();
        Menu menu = new Menu();
        //Person user = new Person();
        //od ID zależą prawa użytkownika (Pracownik,Administrator,Użytkownik)
        int id = 0;
        Person user = null;
        boolean check = false;
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        while (!check) {
            check = menu.MainMenu();
        }

        while (id == 0) {
            user = menu.Logowanie(users);
            id = user.id;
        }
        System.out.println("Witaj " + user.imie + "!");
        menu.LoggedMenu(user,baza);

    }
}
