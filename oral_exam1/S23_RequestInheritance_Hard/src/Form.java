import java.util.HashMap;

/**
 * Form data type that contains a hashmap where fields can be written. Contains two public methods
 *
 * @author Dean Farwell
 */
public class Form {

    /**
     * HashMap of Strings that contains data written to the fields
     */
    private HashMap<String, String> fields;

    /**
     * Constructor that populates the HashMap with various String passed by the constructor
     * @param fields Hashmap values to be written to the fields variable
     */
    public Form(HashMap<String, String> fields) {
        this.fields = fields;
    }

    /**
     * Getter for fields of a Form
     * @return fields of a Form
     */
    public HashMap<String, String> getFields() {
        return fields;
    }

}
