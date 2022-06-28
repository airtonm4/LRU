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

    private int pageFault = 0;

    public Lru() throws IOException {
        file = new Data();
        this.capacity = file.getCapacity();

        memoryValues = new LinkedList<LinkedListNode>();
        memory = new HashSet<Integer>(capacity);
    }

    public LinkedListNode get(Integer key) {
        if (!memory.contains(key)) {
            return null;
        }
        ListIterator<LinkedListNode> iterator = memoryValues.listIterator(0);
        while (iterator.hasNext()) {
            LinkedListNode node = iterator.next();
            if (key == node.key) {
                return node;
            }
        }
        return null;
    }

    public void set(Integer key, Integer value) {
        System.out.println("Key: " + key + ", " + "Value: " + value);
        LinkedListNode node = get(key);

        if (node == null) {
            LinkedListNode removed = evict();
            node = new LinkedListNode(key, value);
            memoryValues.addLast(node);
            memory.add(key);
            printMemory();
            if (!(removed == null)) {
                System.out.println("\nPágina removida:");
                System.out.println("Key: " + removed.key + ", " + "Value: " + removed.value);
            }
            
            this.pageFault++;
        } else {
            memoryValues.remove(node);
            memoryValues.addLast(node);
            printMemory();
        }
    }

    LinkedListNode evict() {
        if (memoryValues.size() >= this.capacity) {
            LinkedListNode node = memoryValues.remove();
            memory.remove(node.key);
            
            return node;
        }
        return null;
    }

    public int getPageFault() {
        return pageFault;
    }

    String printMemory() {
        ListIterator<LinkedListNode> iteratorTwo = memoryValues.listIterator(0);
        while (iteratorTwo.hasNext()) {
            LinkedListNode node = iteratorTwo.next();

            System.out.print(node.key + "," + node.value + "; ");
        }

        return "";
    }
}
