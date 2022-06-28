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

    LinkedListNode get(Integer key) {
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

    void set(Integer key, Integer value) {
        LinkedListNode node = get(key);

        if (node == null) {
            evict();
            node = new LinkedListNode(key, value);
            memoryValues.addLast(node);
            memory.add(key);
            this.pageFault++;
        } else {
            memoryValues.remove(node);
            memoryValues.addLast(node);
        }
    }

    void evict() {
        if (memoryValues.size() >= this.capacity) {
            LinkedListNode node = memoryValues.remove();
            memory.remove(node.key);
        }
    }

    public int getPageFault() {
        return pageFault;
    }

    String printMemory() {
        ListIterator<LinkedListNode> iterator = memoryValues.listIterator(0);
        String paper = "";
        while (iterator.hasNext()) {
            paper += iterator.next().key + ":" + iterator.next().value + ", ";
        }

        System.out.println(paper);
        return paper;
    }
}
