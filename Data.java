package WorkAmaury;

import java.io.FileWriter;
import java.io.IOException;

public class Data {
    FileWriter Obj;

    Data(Integer capacity) throws IOException {
        try {
            Obj = new FileWriter("WorkAmaury/pages.txt");
            Obj.write(capacity.toString());

        } catch (IOException e) {
            System.out.println("[ERROR] " + e);
            e.printStackTrace();
        }
    }
}
