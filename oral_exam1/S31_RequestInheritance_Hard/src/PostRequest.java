import java.util.UUID;

public class PostRequest extends Request{

    protected String ip;

    public PostRequest(UUID id, String ip) {
        super(id);
        this.ip = ip;
    }
}
