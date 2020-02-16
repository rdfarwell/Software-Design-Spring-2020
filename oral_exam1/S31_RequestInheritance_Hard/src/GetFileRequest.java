import java.util.UUID;

public class GetFileRequest extends GetRequest {

    private File file;

    public GetFileRequest(UUID id, File file) {
        super(id);
        this.file = file;
    }
}
