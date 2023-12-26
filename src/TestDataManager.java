import Date.DataBase;

import java.io.IOException;

/**
 * The type Test data manager.
 */
public class TestDataManager {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataBase dataManager = DataBase.getInstance();
//        dataManager.addData("Hello");
//        dataManager.addData("World");

//        try {
//            // Save current state
////            dataManager.saveToFile("dataManager.ser");
////            System.out.println("Data saved: " + dataManager.getData());
//
//            // Simulate a new program start
//            DataBase.loadFromFile("dataManager.ser");
//            DataBase newDataManager = DataBase.getInstance();
//            System.out.println("Data loaded: " + newDataManager.getData());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
