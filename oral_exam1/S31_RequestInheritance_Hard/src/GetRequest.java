import java.util.Random;
import java.util.UUID;

public class GetRequest extends Request {

    protected String url;
    protected static int numGet;
    private Random rand = new Random();

    public GetRequest(UUID id, String url) {
        super(id);
        this.url = url;
        numGet++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req));
        System.out.print("Universal Resource Locator (URL): " + url);
        return "";
    }

    public static int count() {
        return numGet;
    }
}