package ru.netology.manager;

import ru.netology.repository.Ticker;
import ru.netology.domain.TickerData;


public class ManagerTicker {
    private Ticker ticker;
    private Ticker tickerTMP = new Ticker();

    public ManagerTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public ManagerTicker() {
        this.ticker = new Ticker();
    }

    public void scan(String from, String to) {
        int i = 0;
        TickerData[] result = new TickerData[ticker.getItemsLength()];// тут будем хранить подошедшие запросу продукты
        for (TickerData product : ticker.findAll()) {
            if ((matchesDepartureIATA(product, from)) && (matchesArrivalIATA(product, to))) {
                result[i] = product;
                i++;
            }
        }
        if (i == 0) {
            return;
        }
        for (int a = 0; a <= i - 1; a++) {
            tickerTMP.add(result[a]);
        }

        tickerTMP.sort();
    }

    private boolean matchesDepartureIATA(TickerData product, String search) {
        if (product.getDepartureIATA().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean matchesArrivalIATA(TickerData product, String search) {
        if (product.getArrivalIATA().contains(search)) {
            return true;
        } else {
            return false;
        }

    }

    public void add(TickerData element) {
        ticker.add(element);
    }

    public void sort() {
        ticker.sort();
    }

    public TickerData[] getManagerTicker() {
        return ticker.findAll();
    }

    public TickerData[] getManagerTickerScan() {

        if (tickerTMP.getItemsLength() != 0) {
            return tickerTMP.findAll();
        } else {
            return null;
        }
    }
}
