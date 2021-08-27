package com.company;

public class Seans implements Mediator {
    Film film;
    Data data;
    Sala sala;



    public void NowySeans(Film film, Data data, Sala sala) {
        this.film = film;
        this.data = data;
        this.sala = sala;

    }
    public int zwrocIloscWolnychMiejsc() {
        return sala.GetWolneMiejsca();
    }
    public int zwrocIloscZajetychMiejsc() {
        return sala.iloscMiejsc -sala.GetWolneMiejsca();
    }

    public void rezerwujMiejsca(int ilosc) {
        sala.ZarezerwujMiejsca(ilosc);
    }
    public void wyswietlInformacje() {
        film.Informacje();
        System.out.println("Ilosc wolnych miejsc: " + zwrocIloscWolnychMiejsc());
        sala.InformacjeOSali();
        data.Informacje();
    }

    public void wystawOcene(int ocena) {
        film.WystawOcene(ocena);
    }
    public String GetFilmName() {
        return film.GetFilmName();
    }
    public Data GetFilmDate() {
        return data;
    }

    //Implementacja metod mediatora
    @Override
    public void WystawOcene(float ocena) {
        System.out.println("Wystaw ocenę ");
    }

    @Override
    public void InformacjeOSali() {
        System.out.println("Sala: ");
    }
    //Ustawienie komponentu
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch(component.getName()){
            case "Sala":
                sala = (Sala)component;
                break;
            case "Film":
                film = (Film)component;
                break;
        }
    }

    @Override
    public void Informacje() {
        System.out.println("");
    }
}
