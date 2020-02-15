import java.util.UUID;

public class PostPaymentRequest extends PostRequest {

    protected Payment payment;

    public PostPaymentRequest(UUID id, String ip, Payment payment) {
        super(id, ip);
        this.payment = payment;
    }
}
