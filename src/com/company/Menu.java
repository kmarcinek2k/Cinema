package com.company;

import com.company.Users.*;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public boolean MainMenu(){
        BazaDanych bd = BazaDanych.getInstance();

        System.out.println("Witaj!");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1.Zaloguj się");
        System.out.println("2.Przejrzyj dostepne filmy");
        System.out.println("0.Wyjdz\n");

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();

        switch(a){
            case "1":
                return true;

            case "2":
                User p = new User();
                p.WyswietlFilmy();
                break;
            default:
                System.out.println("Żegnaj!\n");
                System.exit(0);
        }
        return false;
    }
    public Person Logowanie(List<Person> users) {

        Scanner in = new Scanner(System.in);
        System.out.println("\nPodaj nazwe uzytkownika:");
        String nickname = in.nextLine();
        System.out.println("\nPodaj haslo:");
        String password = in.nextLine();
        for(Person p:users) {
            if (p.nickname.equals(nickname) && p.haslo.equals(password) ) {
                System.out.print("\nZalogowano do systemu jako:");
                if(p.id == 3){
                    System.out.println("Admin");
                    return p;
                }
                if(p.id == 2){
                    System.out.println("Pracownik");
                    return p;
                }
                if(p.id == 1){
                    User utemp = (User) p;
                    if(((User) p).extended) {
                        System.out.println(" Użytkownik premium");
                    }else{
                        System.out.println(" Zwykły użytkownik");
                    }
                    return p;
                }

                return p;
            }
        }
        System.out.println("\nBrak takiego uzytkownika");
        User user = new User();
        user.id =0;
    return user;
    }

    void LoggedMenu(Person p, BazaDanych bd){
        if(p.id == 3){
            AdminMenu(bd, (Admin) p);
        }else if(p.id == 1){
            UserMenu(bd, (User) p);
        }

    }

    void AdminMenu(BazaDanych bd, Admin p){
        System.out.println("\nWitaj!");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1.Dodaj film");
        System.out.println("2.Modyfikuj film");
        System.out.println("3.Dodaj nowy seans");
        System.out.println("4.Dodaj nowego użytkownika");
        System.out.println("5.Wyswietl filmy");
        System.out.println("6.Wyswietl repertuar");
        System.out.println("0.Wyjdz");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();

        switch(a) {
            case "1":
                p.DodanieFilmu(bd);
                break;
            case "2":
                break;
            case "3":
                p.NowySeans(bd);
                break;
            case "4":
                p.StworzUzytkownika(bd);
                break;
            case "5":
                p.WyswietlFilmy();
                break;
            case "6":
                p.WyswietlSeanse();
                break;
            case "0":
                System.out.println("\nŻegnaj!");
                System.exit(0);
                break;
            default:
                System.out.println("\nBrak takiej opcji\n");
        }
        AdminMenu(bd,p);
    }


    void UserMenu(BazaDanych bd, User p){
        System.out.println("\nWitaj!");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1.Wyswietl dostepne filmy");
        System.out.println("2.Wyswietl dostepne seanse");
        System.out.println("3.Zarezerwuj seans");
        System.out.println("4.Pokaz zarezerwowane seanse");
        System.out.println("5.Ocen Film");
        System.out.println("0.Wyjdz");

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        UserPro up = null;
        if(p.extended){
            up = new UserPro();
        }

        switch(a){
            case "1":
                p.WyswietlFilmy();
                break;
            case "2":
                p.WyswietlSeanse();
                break;
            case "3":
                p.zarezerwujMiejsce();
                break;
            case "4":
                p.WyswietlRezerwacje();
                break;
            case "5":
                if(p.extended) {
                    up.OcenFilm();
                }else{
                    System.out.println("\nOceniac mogą tylko użytkownicy premium!");
                }
                break;
            case "0":
                System.out.println("\nŻegnaj!");
                System.exit(0);
                break;
            default:
                System.out.println("\nBrak takiej opcji\n");
        }
        UserMenu(bd,p);
    }

}
