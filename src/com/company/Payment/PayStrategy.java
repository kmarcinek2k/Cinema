package com.company.Payment;


//Wzorzec Strategia - funkcja pay nie jest używana gdyż jest to tylko fragment implementacji systemu płatności
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
