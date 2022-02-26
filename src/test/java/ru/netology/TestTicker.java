package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.repository.*;
import ru.netology.domain.*;
import ru.netology.manager.*;

///import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicker {
    TickerData tickerData = new TickerData(1, 2, "DME", "EGO", 90);
    TickerData tickerData2 = new TickerData(1, 5, "EGO", "DME", 90);
    TickerData tickerData1 = new TickerData(1, 4, "DME", "EGO", 90);
    TickerData tickerData3 = new TickerData(1, 27, "EGO", "DME", 90);
    TickerData tickerData4 = new TickerData(1, 8, "LED", "EGO", 90);
    Ticker ticker = new Ticker();

    @Test
    void testSort() {
        ManagerTicker managerTicker = new ManagerTicker();
        managerTicker.add(tickerData);
        managerTicker.add(tickerData2);
        managerTicker.add(tickerData1);
        managerTicker.add(tickerData3);
        managerTicker.add(tickerData4);
        managerTicker.sort();
        TickerData[] expected = new TickerData[]{tickerData, tickerData1, tickerData2, tickerData4, tickerData3};
        assertArrayEquals(expected, managerTicker.getManagerTicker());


    }

    @Test
    void testSortTickers() {
        ManagerTicker managerTicker = new ManagerTicker();
        managerTicker.add(tickerData);
        managerTicker.add(tickerData2);
        managerTicker.add(tickerData1);
        managerTicker.add(tickerData3);
        managerTicker.add(tickerData4);
        managerTicker.scan("DME", "EGO");
        TickerData[] expected = new TickerData[]{tickerData, tickerData1};
        assertArrayEquals(expected, managerTicker.getManagerTickerScan());
    }

    @Test
    void testInterface() {
        ManagerTicker managerTicker = new ManagerTicker(ticker);
        managerTicker.add(tickerData);
        managerTicker.add(tickerData2);
        managerTicker.add(tickerData1);
        managerTicker.add(tickerData3);
        managerTicker.add(tickerData4);
        Arrays.sort(ticker.findAll());
        TickerData[] expected = new TickerData[]{tickerData, tickerData1, tickerData2, tickerData4, tickerData3};
        assertArrayEquals(expected, ticker.findAll());
    }

    @Test
    void testScanNoTickerParametr1() {
        ManagerTicker managerTicker = new ManagerTicker();
        managerTicker.add(tickerData);
        managerTicker.add(tickerData2);
        managerTicker.add(tickerData1);
        managerTicker.add(tickerData3);
        managerTicker.add(tickerData4);
        managerTicker.scan("Test", "Test1");
        assertNull(managerTicker.getManagerTickerScan());
    }

    @Test
    void testScanNoTickerParametr2() {
        ManagerTicker managerTicker = new ManagerTicker();
        managerTicker.add(tickerData);
        managerTicker.add(tickerData2);
        managerTicker.add(tickerData1);
        managerTicker.add(tickerData3);
        managerTicker.add(tickerData4);
        managerTicker.scan("LED", "Test1");
        assertNull(managerTicker.getManagerTickerScan());
    }


}
