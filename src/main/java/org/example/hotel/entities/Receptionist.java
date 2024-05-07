package org.example.hotel.entities;

import static org.Project.Main.allocateGuest;

public class Receptionist extends Thread {

    private final String name;
    public boolean running;


    Receptionist(String name) {
        this.name = name;
        this.running = false;
    }

    public void run() {}

    public boolean getRoom(int numberOfFamily, Guest guest) {
        running = true;
        boolean isGetRoom = allocateGuest(numberOfFamily, guest, this);
        running = false;
        return isGetRoom;
    }

    public String getReceptionistName() {
        return name;
    }
}