package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LockerTest {
    private Locker locker;

    @BeforeEach
    public void setUp() {
        locker = new Locker("A1");
    }


    @Test
    @DisplayName("Test to store item")
    void storeItem() {
        locker.storeItem("Hat");
        assertEquals(true, locker.isOccupied());
        String output = locker.toString();
        assertEquals(true, output.contains("Hat"), "Locker contents should include 'Hat'");

    }

    @Test
    @DisplayName("Test to remove item")
    void removeItem() {
        locker.storeItem("Notebook");
        locker.removeItem();
        assertEquals(false, locker.isOccupied(), "Locker should be empty after removing item");

        String output = locker.toString();
        assertEquals(false, output.contains("Notebook"), "Locker contents should not include notebook");
    }

    @Test
    @DisplayName("Test to get locker id")
    void getLockerId() {
        assertEquals("A1", locker.getLockerId(), "Locker ID should be A1");
    }

    @Test
    @DisplayName("Test to see if locker is occupied")
    void isOccupied() {
        boolean expected = false;
        boolean actual = locker.isOccupied();
        assertEquals(expected, actual);
    }
}
