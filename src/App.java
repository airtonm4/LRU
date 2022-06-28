import java.util.Scanner;

public class App {
    /**
     * Método main, onde vai consistir o inicio e toda a inserção de dados do algoritmo.
     */
    public static void main(String[] args) throws Exception {
        /**
         * Objeto da classe Data, responsável pela a leitura de dados do nosso arquivo txt (pages.txt).
         */
        Data file = new Data();
        /**
         * Objeto da classe LRU, onde consiste o core do nosso algoritmo.
         */
        Lru memory = new Lru();

        /**
         * Objeto Scanner para realizar espera do usuário a cada novo ciclo de entrada de memória.
         */
        Scanner waitLoop = new Scanner(System.in);

        /**
         * Array pegando as linhas de referência do nosso arquivo txt para realizar tratamento.
         */
        String[] fileLines = file.getPagesContent();
        /**
         * Matriz responsável para armazenar os dados das linhas de referência do arquivo txt.
         */
        String[][] auxArr = new String[30][2];

        System.out.println("**************************************");
        System.out.println("            Algoritmo LRU");
        System.out.println("**************************************\n");

        /**
         * Loop atribuindo os valores formatados dentro da matriz.
         */
        for (int i = 0; i < fileLines.length; i++) {
            auxArr[i] = fileLines[i].split(", ");
        }
        
        System.out.println("================ Arquivo lido");
        System.out.println("================ Capacidade de armazenamento: " + file.getCapacity() + "\n");
        System.out.println("================ Iniciando implementação\n");

        /**
         * Loop principal, onde ocorre a inserção de dados dentro do nosso algoritmo LRU.
         */
        for (int i = 0; i < auxArr.length; i++) {
            System.out.println("=============== Ciclo " + (i + 1) + " ===============");
            /**
             * Variável responsavel por converter e receber o valor da matriz.
             */
            Integer key = Integer.parseInt(auxArr[i][0]);
            /**
             * Variável responsavel por converter e receber o valor da matriz.
             */
            Integer value = Integer.parseInt(auxArr[i][1]);

            System.out.println("Página a ser adicionada:");
            /**
             * Inserção de dados dentro do nosso algoritmo LRU.
             */
            memory.set(key, value);
            System.out.println("\nPage fault: " + memory.getPageFault());

            /**
             * Espera o usuário teclar enter, para começar outro ciclo.
             */
            waitLoop.nextLine();
        }

        waitLoop.close();
    }

}
