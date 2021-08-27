package com.company;

//Ustawienie interfaceu mediatora -> implementacja w klasie seans
public interface Mediator {
    void WystawOcene(float ocena);
    void InformacjeOSali();
    void registerComponent(Component component);
    void Informacje();
}
