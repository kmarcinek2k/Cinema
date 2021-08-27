package com.company;
//sala jest komponentem dla mediatora
public class Sala implements Component{
    Mediator mediator;
    public int numer;
    String sponsor;
    int iloscMiejsc;
    int iloscZajetychMiejsc;


    public void CreateRoom(int numer, String sponsor, int iloscMiejsc) {
        this.numer = numer;
        this.sponsor = sponsor;
        this.iloscMiejsc = iloscMiejsc;
        iloscZajetychMiejsc = 0;
    }
    public void InformacjeOSali() {

        System.out.println("Numer sali: " + numer + " sponsor: " + sponsor);
        if(mediator != null)
            mediator.InformacjeOSali();
    }
    public void ZarezerwujMiejsca(int miejsca) {
        iloscZajetychMiejsc += miejsca;
    }
    public int GetWolneMiejsca() {
        return iloscMiejsc - iloscZajetychMiejsc;
    }

    @Override
    public void setMediator(Mediator mediator) {
        if(mediator != null)
            this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "Sala";
    }
}
