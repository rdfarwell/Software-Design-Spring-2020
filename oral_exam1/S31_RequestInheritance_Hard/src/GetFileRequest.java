import java.util.UUID;

public class GetFileRequest extends Request {

    private File file;

    public GetFileRequest(UUID id, File file) {
        super(id);
        this.file = file;
    }
}
