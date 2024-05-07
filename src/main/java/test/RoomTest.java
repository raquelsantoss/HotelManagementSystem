package test;

import org.example.hotel.entities.Guest;
import org.example.hotel.entities.Maid;
import org.example.hotel.entities.Receptionist;
import org.example.hotel.entities.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    private Room room;
    private Maid maid;

    @BeforeEach
    public void setUp() {
        // Initial setup for each test
        room = new Room("9"); // Create a new room with name "9"
        maid = new Maid("Maid"); // Create a new maid
        room.setMaid(maid); // Set the maid for the room
    }

    @Test
    public void testRoomCreation() {
        // Test room creation
        Room room = new Room("1"); // Create a new room with name "1"
        assertEquals("1", room.getName()); // Check if the room name is correct
        assertTrue(room.isAvailable()); // Check if the room is available
        assertTrue(room.isClean()); // Check if the room is clean
    }

    @Test
    public void testAddGuest() {
        // Test adding guests to the room
        Guest guest1 = new Guest("Guest 1");
        room.addGuest(guest1);
        assertTrue(room.getGuests().contains(guest1));

        Guest guest2 = new Guest("Guest 2");
        room.addGuest(guest2);
        assertTrue(room.getGuests().contains(guest2));
        assertEquals(2, room.getGuests().size());
    }

    @Test
    public void testGetRoomForLargeGroupSameRoom() {
        // Test getting room for a large group where the room is not available
        Receptionist receptionist = new Receptionist("Caio");
        Guest guest = new Guest("Raquel");
        assertFalse(receptionist.getRoom(11, guest));
    }

    @Test
    public void testRemoveAllGuest() {
        // Test removing all guests from the room
        Guest guest1 = new Guest("John Doe");
        Guest guest2 = new Guest("Karen Doe");
        room.addGuest(guest1);
        room.addGuest(guest2);
        room.removeAllGuest();
        assertTrue(room.getGuests().isEmpty());
    }

    @Test
    public void testToggleAvailable() {
        // Test toggling room availability
        assertTrue(room.isAvailable());
        room.toggleAvailable();
        assertFalse(room.isAvailable());
    }

    @Test
    public void testRoomCleaning() {
        // Test room cleaning process
        Room room = new Room("5");
        Maid maid = new Maid("Maid");

        room.setMaid(maid);
        room.cleanRoom();
        assertTrue(room.isClean());
    }

    @Test
    public void testCheckout() {
        // Test guest checkout process
        room.addGuest(new Guest("Guest 1"));
        room.addGuest(new Guest("Guest 2"));
        assertFalse(room.getGuests().isEmpty());
        room.checkout();
        assertTrue(room.getGuests().isEmpty());
    }

    @Test
    public void testIsAvailable() {
        // Test checking room availability
        assertTrue(room.isAvailable());
        room.toggleAvailable();
        assertFalse(room.isAvailable());
    }

    @Test
    public void testSetClean() {
        // Test setting room cleanliness
        room.setClean(true);
        assertTrue(room.isClean());
        room.setClean(false);
        assertFalse(room.isClean());
    }
}
