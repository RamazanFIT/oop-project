import Actors.User;

import java.io.*;
import java.util.Vector;

/**
 * The type String data holder.
 */
public class StringDataHolder implements Serializable {
    public static Vector<String> strings;
    private static StringDataHolder instance = new StringDataHolder();

    private StringDataHolder() {
        strings = new Vector<>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static StringDataHolder getInstance() {
        return instance;
    }

    /**
     * Gets strings.
     *
     * @return the strings
     */
    public Vector<String> getStrings() {
        return strings;
    }

    /**
     * Sets strings.
     *
     * @param strings the strings
     */
    public void setStrings(Vector<String> strings) {
        this.strings = strings;
    }

    /**
     * Add string.
     *
     * @param string the string
     */
    public void addString(String string) {
        strings.add(string);
    }

    /**
     * Remove string.
     *
     * @param string the string
     */
    public void removeString(String string) {
        strings.remove(string);
    }

    /**
     * Serialize.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
// Serialization method
    public void serialize(String filename) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(strings);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * Deserialize string data holder.
     *
     * @param filename the filename
     * @return the string data holder
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
// Deserialization method
    public static void deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        StringDataHolder dataHolder = (StringDataHolder) objectInputStream.readObject();
        strings = (Vector<String>)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
//        this.strings = dataHolder.getStrings();
//        strings = dataHolder.getStrings();
        System.out.println(strings);
    }
}
