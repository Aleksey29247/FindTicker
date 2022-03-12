package ru.netology.domain;

import ru.netology.repository.Ticket;

import java.util.Objects;

public class TicketData implements Comparable<TicketData> {
    public int id;
    public int price;
    public String departureIATA;
    public String arrivalIATA;
    public int tripTime;

    public TicketData(int id, int price, String departureIATA, String arrivalIATA, int tripTime) {
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
    public int compareTo(TicketData obj) {

        return this.price - obj.getPrice();
    }
}
