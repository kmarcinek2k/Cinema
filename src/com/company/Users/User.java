package com.company.Users;

import com.company.*;
import com.company.Payment.PayByCash;
import com.company.Payment.PayByCreditCard;
import com.company.Payment.PayStrategy;

import javax.print.attribute.standard.Media;
import java.util.Scanner;

public class User extends Person {
    public boolean extended;
    private static PayStrategy strategy;
    public User() {
        id = 1;
    }

    public User(User target) {
        target.id = 1;
    }

    public User(String nickname, String pass, String imie, String nazwisko, String adres, int nrTelefonu,boolean extended) {
        this.nickname = nickname;
        this.haslo = pass;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
        id = 1;
        this.extended = extended;

    }

    //Funkcja clone zwraca użytkownika o takich samych parametrach jak obiekt który kopiujemy - wzorzec prototyp
    @Override
    public Person clone() {
        return new User(this);
    }

    public void zarezerwujMiejsce() {
        BazaDanych bd = BazaDanych.getInstance();
        System.out.println("Wybierz seans:\n");
        WyswietlSeanse();
        Scanner in = new Scanner(System.in);
        System.out.println("Wprowadz nazwe filmu:");
        String nazwa = in.nextLine();
        System.out.println("\nWprowadz rok:");
        String year = in.nextLine();
        System.out.println("\nWprowadz miesiąc:");
        String month = in.nextLine();
        System.out.println("\nWprowadz dzień:");
        String day = in.nextLine();
        System.out.println("\nWprowadz godzine:");
        String hour = in.nextLine();
        System.out.println("\nWprowadz minute:");
        String minute = in.nextLine();
        Data d1 = new Data();
        d1.SetData(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));

        System.out.println("\nIle miejsc:");
        String miejsca = in.nextLine();
        if (bd.repertuar.rezerwujMiejsce(nazwa, d1, Integer.parseInt(miejsca))) {
            System.out.println("\nPomyślnie zarezerwowano");
            Rezerwacja r = new Rezerwacja();
            r.SetValues(Integer.parseInt(miejsca), bd.repertuar.getSeans(nazwa, d1, Integer.parseInt(miejsca)), nickname);
            bd.rezerwacje.add((r));
        } else {
            System.out.println("\nNiestety nie udalo się zarezerwować:");
        }

    }

    public void WyswietlRezerwacje() {
        BazaDanych bd = BazaDanych.getInstance();
        int suma = 0;
        for (Rezerwacja r : bd.rezerwacje) {
            if (r.username == nickname) {
                r.WyswietlInformacje();
                suma += r.pobierzSume();
            }
        }
        System.out.println("Do zaplaty = " + suma);
        System.out.println("Czy chcesz zaplacic? t/n ");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        switch (a) {
            case "t":
                System.out.println("Wybierz metode platnosci:");
                System.out.println("1-Gotowka na miejscu");
                System.out.println("2-Karta kredytowa");
                String b = in.nextLine();

                switch (b) {
                    case "1":
                        strategy = new PayByCash();
                        System.out.println("Platność gotówką");
                        break;
                    case "2":
                        strategy = new PayByCreditCard();
                        System.out.println("Płatność kartą");
                        break;
                    default:
                        System.out.println("Brak takiej opcji");
                        break;
                }
                break;
        }
    }


}
