package ru.netology.domain;

import ru.netology.repository.*;

import java.util.Objects;

public class TickerData implements Comparable<TickerData> {
    public int id;
    public int price;
    public String departureIATA;
    public String arrivalIATA;
    public int tripTime;

    public TickerData(int id, int price, String departureIATA, String arrivalIATA, int tripTime) {
        this.id = id;
        this.price = price;
        this.departureIATA = departureIATA;
        this.arrivalIATA = arrivalIATA;
        this.tripTime = tripTime;
    }


    public int getPrice() {
        return price;
    }

    public String getArrivalIATA() {
        return arrivalIATA;
    }

    public String getDepartureIATA() {
        return departureIATA;
    }

    @Override
    public int compareTo(TickerData obj) {

        return this.price - obj.getPrice();
    }
}
