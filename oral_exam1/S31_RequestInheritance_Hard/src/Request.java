import java.util.UUID;

public class Request {

    protected UUID uuid;
    protected static int numRequest;

    public Request(UUID id) {
        uuid = id;
        numRequest++;
    }

    public static int count() {
        return numRequest;
    }
}