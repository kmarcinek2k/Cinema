package com.company.Users;

import com.company.BazaDanych;
import com.company.Film;

import java.util.Scanner;

public class UserPro extends User {

    //Użytkownik premium - wzorzec Mostu - funkcja OcenFilm jest wywoływana tylko przez użytkownika premium
    public void OcenFilm() {
        BazaDanych bd = BazaDanych.getInstance();
        Scanner in = new Scanner(System.in);
        System.out.println("Wprowadz nazwe filmu:");
        String nazwa = in.nextLine();
        System.out.println("Ocen film od 1 do 10:");
        String ocena = in.nextLine();

        if (Integer.parseInt(ocena) < 1 || Integer.parseInt(ocena) > 10) {
            System.out.println("Nieprawidłowa skala ocen");
            System.out.println("Ocen film od 1 do 10:");
        } else {
            for (Film f : bd.filmy) {
                if (f.GetFilmName().compareTo(nazwa) == 0) {
                    f.WystawOcene(Integer.parseInt((ocena)));
                }
            }
        }
    }
}
