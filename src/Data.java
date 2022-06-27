import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Data {
    private String fileName = "src/pages.txt";
    FileReader fileReader;

    Data() throws IOException {
        try {
            fileReader = new FileReader(fileName);

        } catch (IOException e) {
            System.out.println("[ERROR] " + e);
            e.printStackTrace();
        }
    }

    public String[] getPagesContent() {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);
            // Pulando a primeira linha.
            bufferedReader.readLine();
            String[] lineString = new String[30];
            
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

    public Integer getQuantity() {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            // Pegando a primeira linha
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
