import java.util.UUID;

/**
 * Object class that extends PostRequest by adding a payment data type
 * @see PostRequest
 *
 * @author Dean Farwell
 */
public class PostPaymentRequest extends PostRequest {

    /**
     * Payment data type that has a Sender, amount, and receiver
     */
    protected Payment payment;

    /**
     * Total number of Payment objects created
     */
    private static int numPayment;

    /**
     * Constructor that initializes the Payment, UUID, and IP
     * @param id UUID of the PostPaymentRequest
     * @param ip IP address of the PostPaymentRequest
     * @param payment Payment object of the PostPaymentRequest that adds a sender, amount, and receiver
     */
    public PostPaymentRequest(UUID id, String ip, Payment payment) {
        super(id, ip);
        this.payment = payment;
        numPayment++;
    }

    /**
     * Override of PostRequest's toString that adds output points for Payment's components
     * @return Prints out all components of Payment, UUID, and IP, returns an empty string
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.println("Payment Data");
        System.out.println("Payment Sender: " + payment.getSender());
        System.out.println("Payment Amount: " + payment.getAmount());
        System.out.print("Payment Receiver: " + payment.getReceiver());
        return "";
    }

    /**
     * Returns the total count of PostPaymentRequests created
     * @return Total count of PostPaymentRequests created
     */
    public static int count() {
        return numPayment;
    }
}
