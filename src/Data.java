import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Classe responsável pela a leitura de dados do nosso arquivo txt.
 */
public class Data {
    /**
     * Atributo que referência para o arquivo txt.
     */
    private String fileName = "src/pages.txt";

    Data() {
    }

    /**
     * Método para pegar as linhas de referência do arquivo txt.
     * @return String[ ] Array com as linhas de referência.
     */
    public String[] getPagesContent() {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);
            // Pulando a primeira linha.
            bufferedReader.readLine();
            /**
             * Array armazenando as linhas.
             */
            String[] lineString = new String[30];

            /**
             * Loop atribuindo valores do arquivo txt para o array.
             */
            for (int i = 0; i < lineString.length; i++) {
                lineString[i] = bufferedReader.readLine();
                // System.out.println(lineString[i]);
            }

            bufferedReader.close();
            fileReader.close();
            return lineString;

        } catch (Exception e) {
            System.out.println("[ERROR] " + e);
            e.fillInStackTrace();
            return null;
        }
    }

    /**
     * Método para pegar a capacidade especificada na primeira linha do nosso arquivo txt.
     * @return Integer
     */
    public Integer getCapacity() {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);

            /**
             * Pegando a primeira linha do arquivo txt.
             */
            Integer quantity = Integer.parseInt(bufferedReader.readLine());

            fileReader.close();
            bufferedReader.close();
            return quantity;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e);
            e.printStackTrace();
            return null;
        }
    }
}
