import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class Lru {
    LinkedList<LinkedListNode> memoryValues;
    Set<Integer> memory;

    private int capacity;
    private Data file;

    public Lru() throws IOException {
        file = new Data();
        this.capacity = file.getQuantity();

        memoryValues = new LinkedList<LinkedListNode>();
        memory = new HashSet<Integer>(capacity);
    }

    LinkedListNode get(Integer key) {
        memory.add(10);
        memoryValues.addLast(new LinkedListNode(10, 26));
        if (!memory.contains(key)) {
            System.out.println("null");
            return null;
        }
        ListIterator<LinkedListNode> iterator = memoryValues.listIterator(0);
        while (iterator.hasNext()) {
            LinkedListNode node = iterator.next();
            if(key == node.key){
                return node;
            }
        }
        return null;
    }

    void set(Integer key, Integer value) {
        LinkedListNode node;
    }
}
