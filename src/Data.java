import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Data {
    private FileWriter Obj;
    private String fileName = "src/pages.txt";

    Data(Integer capacity) throws IOException {
        try {
            this.Obj = new FileWriter(fileName);
            this.Obj.write(capacity.toString() + "\n");
            generateRows();

        } catch (IOException e) {
            System.out.println("[ERROR] " + e);
            e.printStackTrace();
        }
    }

    private void generateRows() throws IOException {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Integer number = random.nextInt(50);
            this.Obj.write(number.toString() + "\n");

            // System.out.println(number);
        }
        Obj.close();
    }

    public Integer[] getPagesContent() {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(fileName);

            bufferedReader = new BufferedReader(fileReader);
            // Pulando a primeira linha.
            bufferedReader.readLine();
            Integer[] line = new Integer[50];

            for (int i = 0; i < line.length; i++) {
                line[i] = Integer.parseInt(bufferedReader.readLine());
            }

            bufferedReader.close();
            fileReader.close();
            return line;

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