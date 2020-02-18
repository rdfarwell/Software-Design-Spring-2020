import java.util.UUID;

public class PostPaymentRequest extends PostRequest {

    protected Payment payment;
    private static int numPayment;

    public PostPaymentRequest(UUID id, String ip, Payment payment) {
        super(id, ip);
        this.payment = payment;
        numPayment++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req)); // how to get memory address to appear
        System.out.println("Payment Data");
        System.out.println("Payment Sender: " + payment.getName1());
        System.out.println("Payment Amount: " + payment.getPayment());
        System.out.print("Payment Receiver: " + payment.getName2());
        return "";
    }

    public static int count() {
        return numPayment;
    }
}
