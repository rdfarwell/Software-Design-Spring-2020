import java.util.UUID;

/**
 * Object that extends Request and adds an ip address
 * @see Request
 *
 * @author Dean Farwell
 */
public class PostRequest extends Request{

    /**
     * The ip address of the PostRequest
     */
    protected String ip;

    /**
     * Total number of PostRequests created
     */
    private static int numPost;

    /**
     * Constructor that initializes the UUID and ip
     * @param id UUID of the PostRequest
     * @param ip IP address of the PostRequest
     */
    public PostRequest(UUID id, String ip) {
        super(id);
        this.ip = ip;
        numPost++;
    }

    /**
     * Override of Request's toString that adds output of the IP address
     * @return Prints the components of the PostRequest, returns an empty String
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.print("Post request to server with IP address: " + ip);
        return "";
    }

    /**
     * Return count of created PostRequests
     * @return Total number of created PostRequests
     */
    public static int count() {
        return numPost;
    }
}
