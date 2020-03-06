import java.util.Map;
import java.util.UUID;

/**
 * Object that extends PostFormRequest and adds an encryption method
 * @see PostFormRequest
 *
 * @author Dean Farwell
 */
public class PostEncryptedFormRequest extends PostFormRequest {

    /**
     * The encryption method used
     */
    protected String encryption;

    /**
     * Total number of PostEncryptedFormRequests created
     */
    private static int numEncryptForm;

    /**
     * Constructor that initializes the UUID, IP, Form, and encryption method
     * @param id UUID of the PostEncryptedFormRequests
     * @param ip IP address of the PostEncryptedFormRequests
     * @param form Form within the PostEncryptedFormRequests
     * @param encryption encryption method used by the PostEncryptedFormRequests
     */
    public PostEncryptedFormRequest(UUID id, String ip, Form form, String encryption) {
        super(id, ip, form);
        this.encryption = encryption;
        numEncryptForm++;
    }

    /**
     * Override of PostFormRequest's toString that adds output of the encryption method
     * @return Prints the components of the PostEncryptedFormRequest, returns an empty String
     */
    @Override
    public String toString() {
        System.out.print(super.toString());
        System.out.print("This form was encrypted using: " + encryption);
        return "";
    }

    /**
     * Returns the total number of PostEncryptedFormRequests created
     * @return Total number of PostEncryptedFormRequests created
     */
    public static int count() {
        return numEncryptForm;
    }
}
