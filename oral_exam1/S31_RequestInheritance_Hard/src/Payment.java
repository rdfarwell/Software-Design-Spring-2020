public class Payment {

    private String name1, name2;
    private int payment;

    public Payment(String name1, int payment, String name2) {
        this.name1 = name1;
        this.payment = payment;
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public int getPayment() {
        return payment;
    }
}