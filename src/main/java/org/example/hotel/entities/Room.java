package org.example.hotel.entities;


import java.util.ArrayList;
import java.util.List;

public class Room {

    private static final int TIME_CLEAN = 1500;

    private final String name;
    private boolean available;
    private boolean Clean;
    private Maid maid;
    private final List<Guest> guests;

    public Room(String name) {
        this.name = name;
        this.guests = new ArrayList<>();
        this.available = true;
        this.Clean = true;
    }

    public String getName() {
        return name;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void removeAllGuest() {
        guests.clear();
    }

    public void setMaid(Maid maid) {
        this.maid = maid;
    }

    public void toggleAvailable() {
        available = !available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void cleanRoom() {
        Clean = false;
        System.out.println(maid.getMaidName() + " pegou a chave do " + name + " com a recepcionista");
        System.out.println(maid.getMaidName() + " está limpando o quarto " + name);
        try {
            maid.sleep(TIME_CLEAN);
            System.out.println(maid.getMaidName() + " terminou de limpar e deixou a chave do " + name + " com a recepcionista");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Clean = true;
    }

    public void checkout(){
        toggleAvailable();
        removeAllGuest();
    }

    public boolean isClean(){
        return Clean;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setClean(boolean clean) {
        Clean = clean;
    }

    public Maid getMaid() {
        return maid;
    }
}
