package org.example.services;
import org.example.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryServiceTest {

    private MemoryService service;

    @BeforeEach
    public void setup() {
        service = new MemoryService();
    }

    @Test
    public void testToAddMemoryInList() {
        Memory memory = new Memory(1, "Alex", "Graduation day was amazing!", true);
        service.addMemory(memory);
        List<Memory> allMemories = service.getAllMemories();

        assertEquals(1, allMemories.size());
        assertEquals(memory, allMemories.get(0));
    }

    @Test
    public void testToGetAllMemories() {

    }
}
