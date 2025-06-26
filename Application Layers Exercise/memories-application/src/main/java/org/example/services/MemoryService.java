package org.example.services;
import org.example.models.Memory;
import java.util.ArrayList;
import java.util.List;

public class MemoryService {
    private List<Memory> memories = new ArrayList<>();

    public void addMemory(Memory memory) {
        memories.add(memory);
    }

    public List<Memory> getAllMemories() {
        return new ArrayList<>(memories);
    }

    public List<Memory> getPublicMemories() {
        List<Memory> result = new ArrayList<>();
        for (Memory memory : memories) {
            if (memory.isShareable()) {
                result.add(memory);
            }
        }
        return result;
    }

    public boolean hasMemories() {
        return !memories.isEmpty();
    }

}
