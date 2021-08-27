package com.company.Payment;

import com.company.BazaDanych;

import java.io.IOException;
//Metoda implementujące interfejs ze wzorca strategia
public class PayByCash implements PayStrategy  {
    int amount;
    int cashAmount;
    String nickname;
    @Override
    public void collectPaymentDetails() {
      setAmount(amount);
        BazaDanych baza = BazaDanych.getInstance();
      nickname = baza.personList.get(getIndexOfPerson(0,baza)).nickname;
    }
    void setAmount(int a){
        amount = a;
    }
    int getIndexOfPerson(int index,BazaDanych db){
        db.personList.get(index);
        return index;
    }

    public boolean pay(int paymentAmount) {
        if (cashAmount >= paymentAmount) {
            System.out.println("Zaplacono " + paymentAmount + " uzywając gotówki");
            System.out.println("Reszta " + (cashAmount - paymentAmount)+ " zł");
            return true;
        } else {
            return false;
        }
    }
}
