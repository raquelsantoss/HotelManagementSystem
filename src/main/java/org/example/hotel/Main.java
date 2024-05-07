package org.example.hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.example.hotel.entities.Guest;
import org.example.hotel.entities.Receptionist;
import org.example.hotel.entities.Room;

public class Main {

    public static final List<Room> ROOMS = new ArrayList<>();
    public static final List<Receptionist> RECEPTIONISTS = new ArrayList<>();
    public static final List<Guest> GUESTS = new ArrayList<>();

    public static Lock lock = new ReentrantLock();

    private static final int NUM_ROOMS = 10;
    private static final int NUM_GUESTS = 50;
    private static final int NUM_MAIDS = 10;
    private static final int NUM_RECEPTIONISTS = 5;
    private static final int MAX_ROOM_SIZE = 4;


    public static void main(String[] args) {

        // Create guests, receptionists, maids, and rooms
        Guest[] guests = new Guest[NUM_GUESTS];
        for (int i = 0; i < NUM_GUESTS; i++) {
            guests[i] = new Guest("Hóspede " + (i + 1));
        }

        Receptionist[] receptionists = new Receptionist[NUM_RECEPTIONISTS];
        for (int i = 0; i < NUM_RECEPTIONISTS; i++) {
            receptionists[i] = new Receptionist("Recepcionista " + (i + 1));
        }

        Maid[] maids = new Maid[NUM_MAIDS];
        for (int i = 0; i < NUM_MAIDS; i++) {
            maids[i] = new Maid("Camareira " + (i + 1));
        }

        Room[] rooms = new Room[NUM_ROOMS];
        for (int i = 0; i < NUM_ROOMS; i++) {
            rooms[i] = new Room("quarto  " + (i + 1));
        }

        // Assign maids to rooms
        for (int i = 0; i < NUM_MAIDS; i++) {
            rooms[i].setMaid(maids[i]);
        }

        // Add all entities to their respective lists
        GUESTS.addAll(Arrays.asList(guests));
        ROOMS.addAll(Arrays.asList(rooms));
        RECEPTIONISTS.addAll(Arrays.asList(receptionists));

        // Start guest and receptionist threads
        Arrays.stream(guests).forEach(Thread::start);
    }

    public static boolean allocateGuest(int numberOfFamily, Guest guest, Receptionist receptionist) {
        lock.lock();
        try {
            Optional<Room> room;

            List<Optional<Room>> rooms = new ArrayList<>();

            for (int i = 0; i < numberOfFamily; i++) {
                if (i % MAX_ROOM_SIZE == 0) {
                    room = availableRoom();
                    if (room.isEmpty()) {
                        for(Optional<Room> r : rooms) {
                            r.ifPresent(Room::toggleAvailable);
                        }
                        return false;
                    }else {
                        room.get().toggleAvailable();
                        rooms.add(room);
                    }
                }
            }

            for (Optional<Room> availableRoom : rooms){
                if (availableRoom.isPresent()) {
                    availableRoom.get().addGuest(guest);
                    guest.addRooms(availableRoom.get());
                }
            }
            System.out.println(receptionist.getReceptionistName() + " alocou um hóspede " + guest.getGuestName() + " e sua família");
            return true;
        }finally {
            lock.unlock();
        }
    }

    public static Optional<Room> availableRoom() {
        for (Room room : ROOMS) {
            if (room.isAvailable()) {
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }
}



