package com.company.Users;

import com.company.BazaDanych;
import com.company.Data;
import com.company.Film;

import java.util.Scanner;

public abstract class Person {
    public String nickname;
    public  String imie;
    public  String nazwisko;
    public String adres;
    public String haslo;
    public  int nrTelefonu;
    public int id;

    public Person(){

    }
    public Person(String nickname,String pass, String imie,String nazwisko,String adres,int nrTelefonu){
    this.nickname = nickname;
    this.haslo = pass;
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.adres = adres;
    this.nrTelefonu = nrTelefonu;
    }
    public Person(Person target){
        if(target != null){
            this.imie = target.imie;
            this.nazwisko = target.nazwisko;
            this.nickname = target.nickname;
            this.haslo = target.haslo;
            this.adres = target.adres;
            this.nrTelefonu = target.nrTelefonu;
        }
    }

    //wzorzec prototyp słóżący do kopiwania klasy
    public abstract Person clone();


    public void WyswietlFilmy(){
        BazaDanych bd = BazaDanych.getInstance();
        System.out.println("Filmy:");
        for(Film f: bd.filmy){
            f.Informacje();
        }
    }

    public void WyswietlSeanse(){
        BazaDanych bd = BazaDanych.getInstance();
        System.out.println("Wybierz:");
        System.out.println("1.Wyswietl wszystkie seanse");
        System.out.println("2.Wyswietl dla konkretnego filmu");
        System.out.println("3.Wyswietl dla konkretnej daty");
        System.out.println("4.Wróc");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        boolean b = false;

        switch(a){
            case "1":
                bd.repertuar.wyswietlRepertuar(Integer.parseInt(a),"",null);
                break;
            case "2":
                System.out.println("\nWprowadz nazwe filmu:");
                String nazwa = in.nextLine();
                bd.repertuar.wyswietlRepertuar(Integer.parseInt(a),nazwa,null);
                break;
            case "3":
                System.out.println("\nWprowadz rok:");
                String year = in.nextLine();
                System.out.println("\nWprowadz miesiąc:");
                String month = in.nextLine();
                System.out.println("\nWprowadz dzień:");
                String day = in.nextLine();
                Data d1 = new Data();
                d1.SetData(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day),0,0);
                bd.repertuar.wyswietlRepertuar(Integer.parseInt(a),"" ,d1);
                break;
            case "4":
                b = true;
                break;
            default:
                System.out.println("\nBrak takiej opcji");
        }
        if(b!= true) {
            WyswietlSeanse();
        }
    }



}
