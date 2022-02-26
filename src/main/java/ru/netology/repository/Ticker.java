package ru.netology.repository;

import ru.netology.domain.TickerData;

public class Ticker {
    private TickerData[] items = new TickerData[0];

    ///public Ticker


    public void add(TickerData item) {
        int length = items.length + 1;
        TickerData[] tmp = new TickerData[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TickerData[] findAll() {
        return items;

    }
    public int getItemsLength()
    {
        if (items.length==0)
        {return 0;}
        return items.length;
    }
    public  void sort() {
        TickerData tmp;
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
