import java.util.UUID;

public class PostEncryptedPaymentRequest extends PostPaymentRequest {

    private String encryption;

    public PostEncryptedPaymentRequest(UUID id, String ip, Payment payment, String encryption) {
        super(id, ip, payment);
        this.encryption = encryption;
    }
}
