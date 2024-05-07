package org.example.hotel.entities;

import java.util.ArrayList;
import java.util.List;

public class Guest extends Thread {
    private static final int TIME_WALK = 2000;
    private static final int TIME_WAIT = 20000;

    private static final int MAX_FAMILY_SIZE = 8;

    private final String name;
    private final List<Room> rooms = new ArrayList<>();
    private int tries;
    private boolean running;

    public Guest(String name) {
        this.name = name;
        this.running = true;
        this.tries = 0;
    }

}
