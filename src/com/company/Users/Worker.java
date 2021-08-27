package com.company.Users;

import com.company.BazaDanych;
import com.company.Data;

import java.util.Scanner;

public class Worker extends Person implements GetID {
    public Worker(){
        id=2;
    }
    public Worker(Worker target){
        target.id=2;
    }
    public Worker(String nickname,String pass, String imie,String nazwisko,String adres,int nrTelefonu){
        this.nickname = nickname;
        this.haslo = pass;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
        id=2;
    }

    @Override
    public Person clone() {
        return new Worker(this);
    }

    public void zarezerwujMiejsce(){
        BazaDanych bd = BazaDanych.getInstance();
        System.out.println( "Wybierz seans:\n");
        WyswietlSeanse();
        Scanner in = new Scanner(System.in);
        System.out.println( "Wprowadz nazwe filmu:");
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
        d1.SetData(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));

        System.out.println("\nIle miejsc:");
        String miejsca = in.nextLine();
        if(bd.repertuar.rezerwujMiejsce(nazwa,d1,Integer.parseInt(miejsca))){
            System.out.println("\nPomyślnie zarezerwowano");
        }else{
            System.out.println("\nNiestety nie udalo się zarezerwować:");
        }

    }

    @Override
    public int getUserID() {
        return id;
    }
}
