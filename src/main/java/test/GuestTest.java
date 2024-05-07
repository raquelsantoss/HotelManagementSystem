package test;

import org.example.hotel.entities.Guest;
import org.example.hotel.entities.Receptionist;
import org.example.hotel.entities.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class GuestTest {

    private Guest guest;
    private Receptionist receptionist;
    private Room room;

    @BeforeEach
    public void setUp() {
        // Setting up common objects for each test
        guest = new Guest("John Doe");
        room = new Room("2");
        receptionist = new Receptionist("Eduardo");
    }

    @Test
    public void testGuestCreation() {
        // Test guest creation
        Guest guest = new Guest("John Doe");
        assertEquals("John Doe", guest.getGuestName());
    }

    @Test
    public void testAddRooms() {
        // Test adding rooms to guest
        Guest guest = new Guest("John Doe");
        Room room1 = new Room("7");
        Room room2 = new Room("8");

        guest.addRooms(room1);
        guest.addRooms(room2);

        assertEquals(2, guest.getRooms().size());
        assertTrue(guest.getRooms().contains(room1));
        assertTrue(guest.getRooms().contains(room2));
    }

    @Test
    public void testRemoveAllRooms() {
        // Test removing all rooms from guest
        Guest guest = new Guest("John Doe");
        Room room1 = new Room("3");
        Room room2 = new Room("4");

        guest.addRooms(room1);
        guest.addRooms(room2);
        guest.removeAllRooms();

        assertEquals(0, guest.getRooms().size());
        assertFalse(guest.getRooms().contains(room1));
        assertFalse(guest.getRooms().contains(room2));
    }

    @Test
    public void testGenerateGroupGuests() {
        // Test generating group size for guests
        Guest guest = new Guest("Maria");
        int groupSize = guest.generateGroup();
        assertTrue(groupSize >= 1 && groupSize <= 8);
    }

    @Test
    public void testRandomNumberToGuestWalk() {
        // Test generating a random number for guest walk behavior
        Guest guest = new Guest("John Doe");

        int number = guest.randomNumber();

        assertTrue(number >= 1 && number <= 2);
    }

    @Test
    void testGetRooms() {
        // Test getting rooms associated with guest
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        guest.addRooms(room);
        assertEquals(rooms, guest.getRooms());
    }
}
