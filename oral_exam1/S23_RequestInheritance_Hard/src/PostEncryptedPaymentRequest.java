import java.util.UUID;

/**
 * Object class that extends PostPaymentRequest by adding an encryption type
 * @see PostPaymentRequest
 *
 * @author Dean Farwell
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest {

    /**
     * Encryption method of the payment request
     */
    private String encryption;

    /**
     * Total number of PostEncryptedPaymentRequests created
     */
    private static int numEncryptPayment;

    /**
     * Constructor that initializes the UUID, IP, Payment, and encryption of the object
     * @param id UUID of the PostEncryptedPaymentRequest
     * @param ip IP address of the PostEncryptedPaymentRequest
     * @param payment Payment of the PostEncryptedPaymentRequest
     * @param encryption Encryption method of the PostEncryptedPaymentRequest
     */
    public PostEncryptedPaymentRequest(UUID id, String ip, Payment payment, String encryption) {
        super(id, ip, payment);
        this.encryption = encryption;
        numEncryptPayment++;
    }

    /**
     * Override of PostEncryptedPaymentRequest's toString that adds output for the encryption method
     * @return Prints out all components of Payment, UUID, and IP, and encryption method, returns an empty string
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.print("This payment was encrypted using: " + encryption);
        return "";
    }

    /**
     * Returns the total count of PostEncryptedPaymentRequests created
     * @return Total count of PostEncryptedPaymentRequests created
     */
    public static int count() {
        return numEncryptPayment;
    }
}
