package test;

import org.example.hotel.entities.Guest;
import org.example.hotel.entities.Maid;
import org.example.hotel.entities.Receptionist;
import org.example.hotel.entities.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReceptionistMaidTest {

    private Room room;
    private Maid maid;

    @BeforeEach
    public void setUp() {
        // Setting up common objects for each test
        room = new Room("Quarto 1");
        maid = new Maid("Camareira 1");
        room.setMaid(maid);
    }

    @Test
    public void testGetReceptionistName() {
        // Test getting receptionist's name
        Receptionist receptionist = new Receptionist("Alice");
        assertEquals("Alice", receptionist.getReceptionistName());
    }

    @Test
    public void testSetMaid() {
        // Test setting maid for a room
        assertEquals(maid, room.getMaid());
        Maid newMaid = new Maid("Nova Camareira");
        room.setMaid(newMaid);
        assertEquals(newMaid, room.getMaid());
    }

    @Test
    public void testGetRoom_UnsuccessfulAllocation() {
        // Test unsuccessful room allocation by receptionist
        Receptionist receptionist = new Receptionist("Eve");
        Guest guest = new Guest("Jane Doe");
        assertFalse(receptionist.getRoom(11, guest)); // Assuming there are not enough rooms
    }

    @Test
    public void testMaidCreation() {
        // Test maid creation
        Maid maid = new Maid("Camareira 1");
        assertEquals("Camareira 1", maid.getMaidName());
    }
}
