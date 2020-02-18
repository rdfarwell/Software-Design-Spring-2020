import java.util.UUID;

public class PostEncryptedPaymentRequest extends PostPaymentRequest {

    private String encryption;
    private static int numEncryptPayment;

    public PostEncryptedPaymentRequest(UUID id, String ip, Payment payment, String encryption) {
        super(id, ip, payment);
        this.encryption = encryption;
        numEncryptPayment++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req)); // how to get memory address to appear
        System.out.print("This payment was encrypted using: " + encryption);
        return "";
    }

    public static int count() {
        return numEncryptPayment;
    }
}
