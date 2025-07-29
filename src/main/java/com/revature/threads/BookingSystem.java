package com.revature.threads;

public class BookingSystem {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        Thread u1 = new Thread(() -> booking.bookTicket("User-A",3));
        Thread u2 = new Thread(() -> booking.bookTicket("User-B",1));
        Thread u3 = new Thread(() -> booking.bookTicket("User-C",2));
        u1.start();
        u2.start();
        u3.start();
    }
}
