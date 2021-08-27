package com.company;

import com.company.Users.Admin;
import com.company.Users.Person;
import com.company.Users.User;
import com.company.Users.Worker;

import java.util.LinkedList;
import java.util.List;

public class BazaDanych {
    private static BazaDanych instance;
    public LinkedList<Person> personList;
    public LinkedList<Film> filmy;
    public LinkedList<Sala> sale;
    public LinkedList<Rezerwacja> rezerwacje;
    public Repertuar repertuar;


    //Korzystanie ze wzorca kreacyjnego singleton - tworzy metodę statyczną zwracającą obiekt klasy
    //Klasa ta może występować tylko raz i być wywoływana globalnie w całym projekcie
    public static BazaDanych getInstance() {
        if (instance == null) {
            instance = new BazaDanych();
        }
        return instance;
    }

    //Tutaj tworzone są wszystkie przykładowe obiekty (symulacja bazy danych)
    private BazaDanych(){
        personList = new LinkedList<Person>();
        filmy = new LinkedList<Film>();
        sale = new LinkedList<Sala>();
        repertuar = new Repertuar();
        rezerwacje = new LinkedList<Rezerwacja>();
        Person u1 = new User("maciekpro","123","Maciek","Stadon","Mieszka3",332123211,true);
        Person u2 = new User("karolxd","321","Karol","Kordian","Popppa 33",123321123,false);
        Person a1 = new Admin("adminpro","admin123","Andrej","Kolonko","Wladyslawa Orkana",554555442);
        Person w1 = new Worker("workerpro","worker123","Mateusz","Lebiega","Sloawckiego 121",666555666);

        personList.add(u1);
        personList.add(u2);
        personList.add(a1);
        personList.add(w1);
        Film f1 = new Film();
        Film f2 = new Film();
        Film f3 = new Film();
        f1.CreateNewFilm("100 lat w tybecie","Leo Messi",17);
        f2.CreateNewFilm("Forrest Dumb","Kopernik JK",12);
        f3.CreateNewFilm("Wilk i zajac","Sztronda",16);
        filmy.add(f1);
        filmy.add(f2);
        filmy.add(f3);

        Sala s1 = new Sala();
        Sala s2 = new Sala();
        Sala s3 = new Sala();
        s1.CreateRoom(1,"Mars",40);
        s2.CreateRoom(2,"Saturn",60);
        s3.CreateRoom(3,"Tesla",4);
        sale.add(s1);
        sale.add(s2);
        sale.add(s3);
        Data d1 = new Data();
        d1.SetData(2020,12,20,14,45);
        repertuar.dodajSeans(f1,d1,s2);
        d1.SetData(2021,1,1,12,30);
        repertuar.dodajSeans(f2,d1,s3);
    }
    public List<Person> DownloadDatabase(){
        return personList;
    }
}
