package ru.netology.repository;

import ru.netology.domain.TicketData;

public class Ticket {
    private TicketData[] items = new TicketData[0];


    public void add(TicketData item) {

        int length = items.length + 1;
        TicketData[] tmp = new TicketData[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketData[] findAll() {
        return items;

    }

    public int getItemsLength() {
        return items.length;
    }

    public void sort() {
        TicketData tmp;
        for (int i = items.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (items[j].getPrice() > items[j + 1].getPrice()) {
                    tmp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = tmp;
                }
            }
        }
    }

}
