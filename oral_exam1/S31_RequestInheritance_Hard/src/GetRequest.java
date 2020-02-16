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

    public GetRequest(UUID id) {
        super(id);
        this.url = "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999)); // TODO: ok or how to call randURL
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