package com.company;

public class Rezerwacja {
    public int iloscMiejsc;
    public Seans seans;
    public int koszt;
    boolean oplacone = false;
    public String username;


    public Rezerwacja(){
        seans = new Seans();
    }
    public void WyswietlInformacje() {
        seans.wyswietlInformacje();
        System.out.println("Ilość miejsc: " + iloscMiejsc);
    }

    public int pobierzSume() {

        return koszt;
    }

    public void SetValues(int ilosc, Seans s,String username){
        iloscMiejsc = ilosc;
        seans = s;
        koszt = seans.film.koszt * ilosc;
        oplacone = false;
        this.username = username;
    }
}
