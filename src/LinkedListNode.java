/**
 * Classe responsável por armazenar as chaves e os valores que serão introduzidos pela a classe LRU.
 */
public class LinkedListNode {
    /**
     * Chave/Índice da página.
     */
    Integer key;
    /**
     * Informação da chave.
     */
    Integer value;

    LinkedListNode() {

    }

    LinkedListNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
