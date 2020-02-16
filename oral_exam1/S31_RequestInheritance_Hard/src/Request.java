import java.util.UUID;

public class Request {

    protected UUID uuid;
    protected static int numRequest;

    public Request(UUID id) {
        uuid = id;
        numRequest++;
    }

    //@Override
    public String toString(Request req) {
        System.out.println(req.toString()); // how to get memory address to appear
        System.out.print("UUID: " + uuid);
        return "";
    }

    public static int count() {
        return numRequest;
    }

}