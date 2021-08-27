package com.company;


//Film jest komponentem wzorca mediator - pozwala to na łączenie filmu i sali do wystawiania ocen filmowi
public class Film implements Component{
    Mediator mediator;
    int koszt;
    String nazwa;
    String tworca;
    int kosztBilet;
    float ocena;
    int iloscOcen = 1;
    boolean checker = true;
   public void CreateNewFilm(String name,String director,int cost) {
        koszt = cost;
        tworca = director;
        nazwa = name;
        this.ocena = 0;
        System.out.println("Dodano nowy film: " + nazwa + "\nStworzony przez: " + tworca + "\nkoszt biletu: " + koszt);
    }
    public void Informacje() {
        System.out.println( "Tytuł filmu: " + nazwa + "\nStworzony przez: " + tworca + "\nocena: " + ocena / iloscOcen +"\nkoszt biletu: " + koszt);
    }

    public void WystawOcene(float ocena) {
       if(checker) {
            checker = false;
       }else{
           iloscOcen++;
       }
        this.ocena += ocena;
        System.out.println("Dziekujemy za ocene!");
        if(mediator != null)
             mediator.WystawOcene(ocena);

    }
    //Ustawienie mediatora
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    //Pobranie nazwy aby potem możliwe było za jego pomocą ustawić odpowiednią klasę
    @Override
    public String getName() {
        return "Film";
    }

    public String GetFilmName() {
        return nazwa;
    }
}
