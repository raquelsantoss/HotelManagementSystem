package org.example.hotel.entities;

public class Maid extends Thread {

    private final String name;


    public Maid(String name) {
        this.name = name;
    }

    public void run() {}

    public String getMaidName() {
        return name;
    }

}
