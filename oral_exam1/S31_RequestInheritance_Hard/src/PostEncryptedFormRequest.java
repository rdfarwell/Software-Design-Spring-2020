import java.util.Map;
import java.util.UUID;

public class PostEncryptedFormRequest extends PostFormRequest {

    protected String encryption;
    protected static int numEncryptForm;

    public PostEncryptedFormRequest(UUID id, String ip, Form form, String encryption) {
        super(id, ip, form);
        this.encryption = encryption;
        numEncryptForm++;
    }

    @Override
    public String toString(Request req) {
        System.out.print(super.toString(req));
        System.out.print("This form was encrypted using: " + encryption);
        return "";
    }

    public static int count() {
        return numEncryptForm;
    }
}
