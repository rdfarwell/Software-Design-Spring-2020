import java.util.UUID;

public class GetFileRequest extends GetRequest {

    private File file;
    private static int numFile;

    public GetFileRequest(UUID id, File file) {
        super(id, ("file://" + file.getPath() + file.getType()));
        this.file = file;
        numFile++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req));
        System.out.println("File Path: " + file.getPath());
        System.out.print("File Type: " + file.getType());
        return "";
    }

    public static int count() { return numFile; }
}
