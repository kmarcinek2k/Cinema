package com.company;

import java.util.LinkedList;
import java.util.List;

public class Repertuar {
    List<Seans> seansList;
    Repertuar(){
        seansList = new LinkedList();
    }
    public void dodajSeans(Film film,Data data, Sala sala) {
        //uruchomienie mediatora i zarejestrowanie komponentów
        Mediator mediator = new Seans();
        mediator.registerComponent(new Sala());
        mediator.registerComponent(new Film());
        Seans seans = new Seans();
        seans.NowySeans(film,data,sala);
        seansList.add(seans);
    }

    public boolean rezerwujMiejsce( String name, Data date, int ilosc) {
        boolean check = false;
        for (Seans s : seansList) {
            if (s.GetFilmName().compareTo(name) ==0 && s.data.PorownajDaty(date)) {
                if(s.zwrocIloscWolnychMiejsc() < ilosc){
                    System.out.println("Za mało wolnych miejsc");
                    check = false;
                }else{
                    check = true;
                    s.rezerwujMiejsca(ilosc);
                    break;
                }

            }
        }
        return check;
    }
    public Seans getSeans( String name, Data date, int ilosc) {
        for (Seans s : seansList) {
            if (s.GetFilmName().compareTo(name) ==0 && s.data.PorownajDaty(date)) {
                return s;
            }

        }

        return null;
    }



    public void wyswietlRepertuar(int r, String name, Data date) {
        System.out.println("REPERTUAR:");
        if (r == 1) {
            for(Seans s : seansList){
                s.wyswietlInformacje();
                System.out.println("\n");
            }

        }else if(r == 2) {
            for (Seans s : seansList) {
                if (s.GetFilmName().compareTo(name) ==0)
                {
                    s.wyswietlInformacje();
                    System.out.println("\n");
                }
            }

        }else if(r == 3) {
            for (Seans s : seansList) {
                if (s.data.PorownajDaty(date)) {
                    s.wyswietlInformacje();
                    System.out.println("\n");
                }
            }
        }

    }


}
