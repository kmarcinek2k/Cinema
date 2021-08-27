package com.company.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Metoda implementujące interfejs ze wzorca strategia
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;


    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Numer karty: ");
            String number = READER.readLine();
            System.out.print("Data waznosci 'mm/yy': ");
            String date = READER.readLine();
            System.out.print("Kod cvv: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);

            // Validate credit card number...

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
