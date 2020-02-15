import java.util.UUID;

public class PostFormRequest extends PostRequest {

    protected Form form;

    public PostFormRequest(UUID id, String ip, Form form) {
        super(id, ip);
        this.form = form;
    }
}
