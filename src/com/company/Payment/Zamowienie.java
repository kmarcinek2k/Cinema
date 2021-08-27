package com.company.Payment;

public class Zamowienie {
    private int calkowityKoszt = 0;
    private boolean czyZamknieto = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
    }

    public void setTotalCost(int cost) {
        this.calkowityKoszt += cost;
    }

    public int getTotalCost() {
        return calkowityKoszt;
    }

    public boolean isClosed() {
        return czyZamknieto;
    }

    public void setClosed() {
        czyZamknieto = true;
    }
}