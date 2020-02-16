import java.util.UUID;

public class PostRequest extends Request{

    protected String ip;
    protected static int numPost;

    public PostRequest(UUID id, String ip) {
        super(id);
        this.ip = ip;
        numPost++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req)); // how to get memory address to appear
        System.out.print("Post request to server with IP address: " + ip);
        return "";
    }

    public static int count() {
        return numPost;
    }
}
