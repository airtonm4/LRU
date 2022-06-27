
public class App {
    public static void main(String[] args) throws Exception {
        Integer capacity = 10;
        
        Data file = new Data();
        Lru lruObj = new Lru();

        file.getPagesContent();
        file.getQuantity();

        lruObj.get(10);


    }

}
