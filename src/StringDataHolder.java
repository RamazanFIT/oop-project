import java.io.*;
import java.util.Vector;

public class StringDataHolder implements Serializable {
    private Vector<String> strings;
    private static StringDataHolder instance = new StringDataHolder();

    private StringDataHolder() {
        strings = new Vector<>();
    }

    public static StringDataHolder getInstance() {
        return instance;
    }

    public Vector<String> getStrings() {
        return strings;
    }

    public void setStrings(Vector<String> strings) {
        this.strings = strings;
    }

    public void addString(String string) {
        strings.add(string);
    }

    public void removeString(String string) {
        strings.remove(string);
    }

    // Serialization method
    public void serialize(String filename) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    // Deserialization method
    public static StringDataHolder deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        StringDataHolder dataHolder = (StringDataHolder) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return dataHolder;
    }
}
