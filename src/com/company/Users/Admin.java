package com.company.Users;

import com.company.*;

import java.util.Scanner;

//Admin dziedziczy po klasie osoba i implementuje interface GetID który powinni używać jedynie pracownicy
public class Admin extends Person implements GetID {
    public Admin(){
        id=3;
    }
    public Admin(Admin target){
        target.id=3;
    }
    public Admin(String nickname,String pass, String imie,String nazwisko,String adres,int nrTelefonu){
        this.nickname = nickname;
        this.haslo = pass;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
        id=3;
    }
    @Override
    public int getUserID(){
        System.out.println( "Admin");
        return id;
    }
    @Override
    public Person clone() {
        return new Admin(this);
    }

    public void DodanieFilmu(BazaDanych bd1){
        BazaDanych bd = BazaDanych.getInstance();
        System.out.println("\nDodawanie nowego filmu");
        System.out.println("\nWpisz nazwe filmu:");
        Scanner in = new Scanner(System.in);
        String nazwa = in.nextLine();
        System.out.println("\nWpisz rezysera:");
        String rezyser = in.nextLine();
        System.out.println("\nWpisz cene biletu:");
        int cena = Integer.parseInt(in.nextLine());
        Film f = new Film();
        f.CreateNewFilm(nazwa, rezyser, cena);
        bd.filmy.add(f);
        System.out.println("\nFilm " + nazwa + " został pomyslnie dodany!!");
    }
    public void NowySeans(BazaDanych bd1){
        BazaDanych bd = BazaDanych.getInstance();
        Film f = new Film();
        System.out.println("\nDodawanie nowego Seansu");
        System.out.println("\nWybierz film");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        for (Film film : bd.filmy) {
            System.out.println(film.GetFilmName());
        }
        a = in.nextLine();
        f = new Film();
        for (Film film : bd.filmy) {
            if (film.GetFilmName().compareTo(a)== 0) {
                f = film;
            }
        }
        System.out.println("\nWybierz numer sali");
        for (Sala s : bd.sale) {
            s.InformacjeOSali();
        }
        a = in.nextLine();
        Sala sala = new Sala();
        for (Sala s : bd.sale) {
            if (Integer.toString(s.numer).compareTo(a) ==0) {
                sala = s;

            }
        }
        System.out.println("\nWybierz datę:");
        System.out.println("Rok");
        int rok = Integer.parseInt(in.nextLine());
        System.out.println("Miesac");
        int month = Integer.parseInt(in.nextLine());
        System.out.println("Dzien");
        int day = Integer.parseInt(in.nextLine());
        System.out.println("Godzina");
        int hour = Integer.parseInt(in.nextLine());
        System.out.println("Minuta");
        int minute = Integer.parseInt(in.nextLine());
        Data d = new Data();
        d.SetData(rok, month, day, hour, minute);
        bd.repertuar.dodajSeans(f, d, sala);
        System.out.println("Repertuar dodany!");


    }
    public void PoliczSume(BazaDanych bd){
        for (Rezerwacja s : bd.rezerwacje) {
                //s.seans.
        }

    }
    public void StworzUzytkownika(BazaDanych bd){
        System.out.println("Tworzenie uzytkownika");
        System.out.println("Wpisz nick:");
        Scanner in = new Scanner(System.in);
        String nick = in.nextLine();
        for (Person p : bd.personList) {
            if (p.nickname == nick) {
                System.out.println("Taki uzytkownik juz istnieje");
                break;
            }
        }
        System.out.println("Wpisz haslo:");

        String haslo = in.nextLine();
        System.out.println("Wpisz imie:");
        String imie = in.nextLine();
        System.out.println("Wpisz nazwisko:");
        String nazwisko = in.nextLine();
        System.out.println("Wpisz adres:");
        String adres = in.nextLine();
        System.out.println("Wybierz role:");
        System.out.println("1-uzytkownik:");
        System.out.println("2-pracownik:");
        System.out.println("3-admin:");
        String type = in.nextLine();
        Person p = ChoseRole(type,nick,haslo,imie,nazwisko,adres,0,false);
        bd.personList.add(p);
    }
    Person ChoseRole(String type,String nick, String pass, String imie,String nazwisko,String adress,int nr,boolean ex){
        if (type.equals("1")) {
            return new User(nick,pass,imie,nazwisko,adress,nr,ex);
        } else if (type.equals("2")) {
            return new Worker(nick,pass,imie,nazwisko,adress,nr);
        } else if (type.equals("3")) {
            return new Admin(nick,pass,imie,nazwisko,adress,nr);
        } else {
            throw new IllegalArgumentException("Unknown car." + type);
        }
    }
}
