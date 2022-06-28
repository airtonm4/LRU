import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * Classe core do nosso algoritmo
 */
public class Lru {
    /**
     * Lista encadeada para de LinkedListNode, que vai armazenar as chaves e os
     * valores.
     */
    LinkedList<LinkedListNode> memoryValues;
    /**
     * Set responsável por armazenar as chaves das páginas disponíveis em memória.
     */
    Set<Integer> memory;

    /**
     * Capacidade de quadros disponível em memória.
     */
    private int capacity;
    /**
     * Objeto da classe Data, para fazer a leitura do arquivo txt.
     */
    private Data file;

    /**
     * Contador de quantos faltas de páginas ocorreram.
     */
    private int pageFault = 0;

    public Lru() throws IOException {
        file = new Data();
        this.capacity = file.getCapacity();

        memoryValues = new LinkedList<LinkedListNode>();
        memory = new HashSet<Integer>(capacity);
    }

    /**
     * Método que busca por um node por meio da sua chave.
     * 
     * @param key Integer
     * @return LinkedListNode | null, retorna o node que corresponde com a key
     *         especificada ou null caso não encontre.
     */
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

    /**
     * Método para atribuir valor dentro do nosso algoritmo.
     * 
     * @param key   Integer
     * @param value Integer
     */
    public void set(Integer key, Integer value) {
        System.out.println("Key: " + key + ", " + "Value: " + value);

        /**
         * Verificamos se a página requisitada já está da memória.
         */
        LinkedListNode node = get(key);

        if (node == null) {
            /**
             * Como a página requisitada não está em memória principal, vai realizar uma
             * checagem para remover o elemento menos recentemento utilizado.
             */
            LinkedListNode removed = evict();

            /**
             * Criando node para inserir dentro da memória principal.
             */
            node = new LinkedListNode(key, value);

            /**
             * Adiciona os valores na memória.
             */
            memoryValues.addLast(node);
            memory.add(key);

            printMemory();
            if (!(removed == null)) {
                System.out.println("\nPágina removida:");
                System.out.println("Key: " + removed.key + ", " + "Value: " + removed.value);
            }

            this.pageFault++;
        } else {
            /**
             * A página já está em memória, assim, vamos apenas mover a página para o
             * início.
             */
            memoryValues.remove(node);
            memoryValues.addLast(node);

            printMemory();
        }
    }

    /**
     * 
     * @return LinkedListNode | null, retorna o método que será removido ou então
     *         retorna null.
     */
    LinkedListNode evict() {
        if (memoryValues.size() >= this.capacity) {
            LinkedListNode node = memoryValues.remove();
            memory.remove(node.key);

            return node;
        }
        return null;
    }

    /**
     * Busca a quantidade de páginas em falta que teve até o momento.
     * 
     * @return int
     */
    public int getPageFault() {
        return pageFault;
    }

    /**
     * Printa o conteúdo atual presenta na memória.
     */
    void printMemory() {
        ListIterator<LinkedListNode> iteratorTwo = memoryValues.listIterator(0);
        while (iteratorTwo.hasNext()) {
            LinkedListNode node = iteratorTwo.next();

            System.out.print(node.key + "," + node.value + "; ");
        }

    }
}
