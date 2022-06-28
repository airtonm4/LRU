import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Data file = new Data();
        Lru memory = new Lru();

        Scanner waitLoop = new Scanner(System.in);

        String[] fileLines = file.getPagesContent();
        String[][] auxArr = new String[30][2];

        System.out.println("**************************************");
        System.out.println("            Algoritmo LRU");
        System.out.println("**************************************\n");
        for (int i = 0; i < fileLines.length; i++) {
            auxArr[i] = fileLines[i].split(", ");
        }
        System.out.println("================ Arquivo lido");
        System.out.println("================ Capacidade de armazenamento: " + file.getCapacity() + "\n");
        System.out.println("================ Iniciando implementação\n");

        for (int i = 0; i < auxArr.length; i++) {
            System.out.println("=============== Ciclo " + (i + 1) + " ===============");
            Integer key = Integer.parseInt(auxArr[i][0]);
            Integer value = Integer.parseInt(auxArr[i][1]);
            System.out.println("Página a ser adicionada:");
            memory.set(key, value);
            System.out.println("\nPage fault: " + memory.getPageFault());

            waitLoop.nextLine();
        }

        waitLoop.close();
    }

}
