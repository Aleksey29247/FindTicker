package ru.netology;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import ru.netology.repository.Ticket;
import ru.netology.domain.TicketData;
import ru.netology.manager.ManagerTicket;




public class TestTicket {
    TicketData ticketData = new TicketData(1, 2, "DME", "EGO", 90);
    TicketData ticketData2 = new TicketData(2, 5, "EGO", "DME", 90);
    TicketData ticketData1 = new TicketData(3, 4, "DME", "EGO", 90);
    TicketData ticketData3 = new TicketData(4, 27, "EGO", "DME", 90);
    TicketData ticketData4 = new TicketData(5, 8, "LED", "EGO", 90);
    Ticket ticket = new Ticket();
    ManagerTicket managerTicket = new ManagerTicket();
    @Test
    void testSort() {
        managerTicket.add(ticketData);
        managerTicket.add(ticketData2);
        managerTicket.add(ticketData1);
        managerTicket.add(ticketData3);
        managerTicket.add(ticketData4);
        managerTicket.sort();
        TicketData[] expected = new TicketData[]{ticketData, ticketData1, ticketData2, ticketData4, ticketData3};
        assertArrayEquals(expected, managerTicket.getManagerTicket());

    }

    @Test
    void testSortTickets() {
        managerTicket.add(ticketData);
        managerTicket.add(ticketData2);
        managerTicket.add(ticketData1);
        managerTicket.add(ticketData3);
        managerTicket.add(ticketData4);
        TicketData[] expected = new TicketData[]{ticketData, ticketData1};
        assertArrayEquals(expected, managerTicket.scan("DME", "EGO"));
    }

    @Test
    void testInterface() {
        ManagerTicket managerTicket1 = new ManagerTicket(ticket);
        managerTicket1.add(ticketData);
        managerTicket1.add(ticketData2);
        managerTicket1.add(ticketData1);
        managerTicket1.add(ticketData3);
        managerTicket1.add(ticketData4);
        Arrays.sort(ticket.findAll());
        TicketData[] expected = new TicketData[]{ticketData, ticketData1, ticketData2, ticketData4, ticketData3};
        assertArrayEquals(expected, ticket.findAll());
    }

    @Test
    void testScanNoTicketParametr1() {
        managerTicket.add(ticketData);
        managerTicket.add(ticketData2);
        managerTicket.add(ticketData1);
        managerTicket.add(ticketData3);
        managerTicket.add(ticketData4);
        TicketData[]  expected = new TicketData[]{};
        assertArrayEquals(expected,managerTicket.scan("Test", "Test1"));
    }

    @Test
    void testScanNoTicketParametr2() {
        managerTicket.add(ticketData);
        managerTicket.add(ticketData2);
        managerTicket.add(ticketData1);
        managerTicket.add(ticketData3);
        managerTicket.add(ticketData4);
        managerTicket.scan("LED", "Test1");
        TicketData[]  expected = new TicketData[]{};
        assertArrayEquals(expected,managerTicket.scan("LED", "Test1"));
    }


}
