package com.company;


//Zwykła klasa do dat
public class Data {
    int year;
    int month;
    int day;
    int hour;
    int minute;
    public Data(){

    }
    public Data(Data target){
        if(target != null){
            this.year = target.year;
            this.month = target.month;
            this.day = target.day;
            this.hour = target.hour;
            this.minute = target.minute;
        }
    }
    public void SetData(int year,int month,int day,int hour,int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;

    }
    public void Informacje() {
        System.out.println( "Dzień " + day + "." + month + "." + year + " godzina " + hour + ":" + minute);
    }
    public boolean PorownajDaty(Data t){
        if(year == t.year && month == t.month && day == t.day && hour == t.hour && minute ==t.minute){
            return true;
        }
        return false;
    }
}
