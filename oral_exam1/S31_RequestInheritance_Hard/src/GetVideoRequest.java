import java.util.UUID;

public class GetVideoRequest extends GetRequest {

    private Video video;

    public GetVideoRequest(UUID id, Video video) {
        super(id);
        this.video = video;
    }
}
