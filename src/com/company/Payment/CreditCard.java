package com.company.Payment;

import java.util.Date;

public class CreditCard {
    String number;
    String date;
    String cvv;
    float amount;
    CreditCard(String number, String date, String cvv){
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }
    void setAmount(float a){
        amount = a;
    }

    float getAmount(){
        return amount;
    }
}
