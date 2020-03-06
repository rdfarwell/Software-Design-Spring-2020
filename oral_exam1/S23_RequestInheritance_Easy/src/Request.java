import java.util.UUID;

/**
 * Request object that has a UUID tied to it and has two methods. One that outputs the contents and another that
 * returns the total number of Request objects created
 *
 * @author Dean Farwell
 */
public class Request {

    /**
     * UUID of the Request object
     */
    protected UUID uuid;

    /**
     * Total number of Request objects
     */
    private static int numRequest;

    /**
     * Constructor for Request object that initializes the UUID
     * @param id UUID to be tied to the Request object
     */
    public Request(UUID id) {
        uuid = id;
        numRequest++;
    }

    /**
     * Override of Object's toString to output each component of the Request object
     * @return Prints each component of Request, and returns an empty string
     */
    @Override
    public String toString() {
        System.out.println("RequestInheritance." + super.toString());
        System.out.print("UUID: " + uuid);
        return "";
    }

    /**
     * Returns the total number of Request created
     * @return Number of Requests created
     */
    public static int count() {
        return numRequest;
    }

}