import java.util.LinkedList;

public class Lru {
    LinkedList<Integer> primaryMemory = new LinkedList<Integer>();
    private int capacity;

    public Lru(int capacity) {
        this.capacity = capacity;
        // primaryMemory.
    }
    
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}


