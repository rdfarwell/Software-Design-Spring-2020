import java.util.UUID;

public class GetRequest extends Request {

    protected String url;

    public GetRequest(UUID id, String url) {
        super(id);
        this.url = url;
    }
}
