package org.example.hotel.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    @Override
    public void run() {
        while (running) {
            int groupSize = generateGroup();
            Optional<Receptionist> availableReceptionist = availableReceptionist();

            if (availableReceptionist.isPresent()) {

                boolean gotRoom = availableReceptionist.get().getRoom(groupSize, this);

                if (gotRoom) {

                    if (randomNumber() == 1){
                        try {
                            do {
                                for (Room room : rooms) {
                                    if (room.isClean()) {
                                        System.out.println(name + " saiu para passear e deixou a chave do " + room.getName() + " com a recepcionista");
                                    }
                                }

                                rooms.get(0).cleanRoom();
                                sleep(TIME_WALK);
                            }while (!rooms.get(0).isClean());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    for (Room room : rooms) {
                        System.out.println(name + " fez check-out e deixou o a chave do  " + room.getName() + " com a recepcionista");
                        room.checkout();
                    }

                    toggleRunning();

                } else if (tries < 1) {
                    System.out.println(name + " Não conseguiu um quarto e entrou na lista de espera");
                    try {
                        sleep(TIME_WAIT);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    tries++;
                }else {
                    System.out.println(name + " não conseguiu um quarto e deixou uma reclamação");
                    toggleRunning();
                }
            }
        }
        removeAllRooms();
    }

    public Optional<Receptionist> availableReceptionist() {
        for (Receptionist receptionist : RECEPTIONISTS) {
            if (!receptionist.running) {
                return Optional.of(receptionist);
            }
        }
        return Optional.empty();
    }

    public String getGuestName() {
        return name;
    }

    public void toggleRunning() {
        running = !running;
    }

    public void addRooms(Room room) {
        this.rooms.add(room);
    }

    public void removeAllRooms() {
        this.rooms.clear();
    }

    public int generateGroup() {
        // Create an instance of Random class
        Random random = new Random();

        // Generate a random number between 1 and 8 (inclusive)
        return random.nextInt(MAX_FAMILY_SIZE) + 1;
    }

    public int randomNumber() {
        // Create an instance of Random class
        Random random = new Random();

        // Generate a random number between 1 and 2 (inclusive)
        return random.nextInt(2) + 1;
    }

    public List<Room> getRooms() {
        return rooms;
    }

}
