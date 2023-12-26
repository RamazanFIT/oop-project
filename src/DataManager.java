import java.io.*;
import java.util.Vector;

/**
 * The type Data manager.
 */
public class DataManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static DataManager instance;
    private Vector<String> data;

    // Private constructor to prevent instantiation
    private DataManager() {
        data = new Vector<>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
// Synchronized method to control simultaneous access
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * Add data.
     *
     * @param element the element
     */
    public void addData(String element) {
        data.add(element);
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Vector<String> getData() {
        return data;
    }

    /**
     * Save to file.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void saveToFile(String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
        }
    }

    /**
     * Load from file.
     *
     * @param filename the filename
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            instance = (DataManager) in.readObject();
        }
    }
}
