package org.hotel;

import java.util.Random;

public class Receptionist implements Runnable {
    private final String name;
    private final Hotel hotel;

    public Receptionist(Hotel hotel, String name) {
        this.hotel = hotel;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                Thread.sleep(random.nextInt(5000)); // Random service time
                synchronized (hotel.getReceptionLock()) {
                    Room room = hotel.getAvailableRoom();
                    if (room != null) {
                        room.occupy();
                        System.out.println(name + " allocated a room " + room.getNumber() + " for a new ");
                    } else {
                        System.out.println(name + " couldn't find available room for a new guest");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}