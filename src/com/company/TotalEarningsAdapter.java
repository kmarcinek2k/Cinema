package com.company;

public class TotalEarningsAdapter extends Film {
    //Tworzyłem też wzorzec adapter służący do sumowania wszystkich pieniędzy z zarezerwowanych seansów lecz było to
    //jednak bezsensowne rozwiązanie
    private Sala sala;

    public TotalEarningsAdapter(Sala sala){
        this.sala = sala;
    }

    public int GetTotal(){
        return sala.iloscZajetychMiejsc;

    }
}
