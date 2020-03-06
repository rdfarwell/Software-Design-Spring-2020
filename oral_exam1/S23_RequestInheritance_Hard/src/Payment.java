/**
 * Data type Payment that includes a sender, receiver, and a payment amount
 *
 * @author Dean Farwell
 */
public class Payment {

    /**
     * Name of the sender of the payment
     */
    private String sender;

    /**
     * Name of the receiver of the payment
     */
    private String receiver;

    /**
     * Total amount sent in payment
     */
    private int amount;

    /**
     * Constructor that initializes the payment's sender, receiver, and amount
     * @param sender Name of the sender of the payment
     * @param amount Total amount sent in the payment
     * @param receiver Name of the receiver of the payment
     */
    public Payment(String sender, int amount, String receiver) {
        this.sender = sender;
        this.amount = amount;
        this.receiver = receiver;
    }

    /**
     * Getter for sender of the payment
     * @return Sender of the payment
     */
    public String getSender() {
        return sender;
    }

    /**
     * Getter for the receiver of the payment
     * @return Receiver of the payment
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Getter for the amount of the payment
     * @return Amount of the payment
     */
    public int getAmount() {
        return amount;
    }
}