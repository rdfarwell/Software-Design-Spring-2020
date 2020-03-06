import java.util.UUID;

/**
 * GetFileRequest object that extends GEtRequest and adds a File data type. Has a constructor and two public methods
 * @see GetRequest
 *
 * @author Dean Farwell
 */
public class GetFileRequest extends GetRequest {

    /**
     * File of the GetFileRequest
     */
    private File file;

    /**
     * Total number of GetFileRequest objects created
     */
    private static int numFile;

    /**
     * Constructor for GetFileRequest that initializes the UUID, URL, and file
     * @param id UUID to be added to GetFileRequest
     * @param file File to be added to GetFileRequest
     */
    public GetFileRequest(UUID id, File file) {
        super(id, ("file://" + file.getPath() + file.getType()));
        this.file = file;
        numFile++;
    }

    /**
     * Override of GetRequest's toString to output each component of the GetFileRequest object
     * @return Prints each component of GetFileRequest, and returns an empty string
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.println("File Path: " + file.getPath());
        System.out.print("File Type: " + file.getType());
        return "";
    }

    /**
     * Return the total number of GetFileRequests created
     * @return Total number of GetFileRequests created
     */
    public static int count() { return numFile; }
}
