import java.util.UUID;

/**
 * GetRequest object that extends Request and adds a url field. Has a constructor and two public methods
 * @see Request
 *
 * @author Dean Farwell
 */
public class GetRequest extends Request {

    /**
     * URL of the GetRequest
     */
    protected String url;

    /**
     * Total number of GetRequest objects created
     */
    private static int numGet;

    /**
     * Constructor for GetRequest that initializes the UUID and URL
     * @param id UUID to be added to the GetRequest
     * @param url URL to be added to the GetRequest
     */
    public GetRequest(UUID id, String url) {
        super(id);
        this.url = url;
        numGet++;
    }

    /**
     * Override of Request's toString to output each component of the GetRequest object
     * @return Prints each component of GetRequest, and returns an empty string
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.print("Universal Resource Locator (URL): " + url);
        return "";
    }

    /**
     * Return the total number of GetRequests created
     * @return Total number of GetRequests created
     */
    public static int count() {
        return numGet;
    }
}