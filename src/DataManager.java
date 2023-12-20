import java.io.*;
import java.util.Vector;

public class DataManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static DataManager instance;
    private Vector<String> data;

    // Private constructor to prevent instantiation
    private DataManager() {
        data = new Vector<>();
    }

    // Synchronized method to control simultaneous access
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addData(String element) {
        data.add(element);
    }

    public Vector<String> getData() {
        return data;
    }

    public void saveToFile(String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        }
    }

    public static void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            instance = (DataManager) in.readObject();
        }
    }
}
