package ru.netology.manager;

import ru.netology.repository.Ticket;
import ru.netology.domain.TicketData;

public class ManagerTicket {
    private Ticket ticket;


    public ManagerTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ManagerTicket() {
        this.ticket = new Ticket();
    }

    public  TicketData[]  scan(String from, String to) {
        int i = 0;
        Ticket ticketTMP = new Ticket();
        TicketData[] result = new TicketData[ticket.getItemsLength()];// тут будем хранить подошедшие запросу продукты
        for (TicketData product : ticket.findAll()) {
            if ((matchesDepartureIATA(product, from)) && (matchesArrivalIATA(product, to))) {
                result[i] = product;
                i++;
            }
        }
        if (i == 0) {
            return ticketTMP.findAll();
        }
        for (int a = 0; a <= i - 1; a++) {
            ticketTMP.add(result[a]);
        }

        ticketTMP.sort();
        return ticketTMP.findAll();
    }

    private boolean matchesDepartureIATA(TicketData product, String search) {
        if (product.getDepartureIATA().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean matchesArrivalIATA(TicketData product, String search) {
        if (product.getArrivalIATA().contains(search)) {
            return true;
        } else {
            return false;
        }

    }

    public void add(TicketData element) {
        ticket.add(element);
    }

    public void sort() {
        ticket.sort();
    }

    public TicketData[] getManagerTicket() {
        return ticket.findAll();
    }


}
