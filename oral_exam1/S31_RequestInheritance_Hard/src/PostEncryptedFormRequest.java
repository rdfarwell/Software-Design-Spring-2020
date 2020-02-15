import java.util.UUID;

public class PostEncryptedFormRequest extends PostFormRequest {

    protected String encryption;

    public PostEncryptedFormRequest(UUID id, String ip, Form form, String encryption) {
        super(id, ip, form);
        this.encryption = encryption;
    }
}
