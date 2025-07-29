package com.revature.threads;

public class TicketBooking {
    private int availableTickets = 5;
    public synchronized void bookTicket(String user, int tickets){
        if(availableTickets>=tickets){
            System.out.println(user+" booked "+tickets+" tickets.");
            availableTickets -=tickets;
        }else{
            System.out.println(user+" failed to book, Not enough tickets");
        }
    }
}
