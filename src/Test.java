import Actors.User;
import Enums.LANGUAGES;

import java.io.IOException;
import java.util.*;

/**
 * The type Test.
 */
public class Test {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StringDataHolder dataHolder = StringDataHolder.getInstance();
//
//        // Add some strings
//        dataHolder.addString("Hello");
//        dataHolder.addString("World");
//
//        // Serialize the data to a file
//        dataHolder.serialize("data.ser");
//        StringDataHolder.deserialize("data.ser");
//        System.out.println(StringDataHolder.strings);
        // Deserialize the data from the file
//        StringDataHolder.deserialize("data.ser");

        // Print the loaded strings to verify they were deserialized correctly
//        for (String s : loadedDataHolder.getStrings()) {
//            System.out.println(s);
//        } //String name, String surname, String password, LANGUAGES lang
//        dataHolder.addString(new User("roma", "syrlybay", "1234", LANGUAGES.EN));
//        dataHolder.addString(new User("rustem", "syrlybay", "1234", LANGUAGES.EN));
//        dataHolder.serialize("data.ser");
//        StringDataHolder loadedDataHolder = StringDataHolder.deserialize("data.ser");
//        StringDataHolder some_data = StringDataHolder.getInstance();
//        some_data.setStrings(((StringDataHolder)StringDataHolder.deserialize("data.ser")).getStrings());

//        System.out.println(some_data.getStrings());
//        System.out.println(((StringDataHolder)StringDataHolder.deserialize("data.ser")).getStrings());
    }
}
