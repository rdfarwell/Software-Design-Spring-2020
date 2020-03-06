import java.util.Map;
import java.util.UUID;

/**
 * Object that extends PostRequest and adds a form data type
 * @see PostRequest
 *
 * @author Dean Farwell
 */
public class PostFormRequest extends PostRequest {

    /**
     * The Form held withing the PostFormRequest
     */
    protected Form form;

    /**
     * Total number of PostFormRequests created
     */
    private static int numForm;

    /**
     * Constructor that initializes the UUID, IP, and Form
     * @param id UUID of the PostFormRequest
     * @param ip IP of the PostFormRequest
     * @param form Form of the PostFormRequest
     */
    public PostFormRequest(UUID id, String ip, Form form) {
        super(id, ip);
        this.form = form;
        numForm++;
    }

    /**
     * Override of PostRequest's toString that adds output of the Form
     * @return Prints the components of the PostFormRequest, returns an empty String
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.println("Form Data");

        // creates a map element that allows for the key and value to be extracted within a loop
        for(Map.Entry mapElement : form.getFields().entrySet()) {
            System.out.println("Label: " + mapElement.getKey());
            System.out.println("Value: " + mapElement.getValue());
        }

        return "";
    }

    /**
     * Return the total number of created PostFormRequests
     * @return Total number of created PostFormRequests
     */
    public static int count() {
        return numForm;
    }
}
