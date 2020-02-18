import java.util.UUID;

public class GetVideoRequest extends GetRequest {

    private Video video;
    private static int numVideo;

    public GetVideoRequest(UUID id, Video video) {
        super(id, video.getURL());
        this.video = video;
        numVideo++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req));
        System.out.println("Video: " + video.getTitle());
        System.out.print("By: " + video.getName());
        return "";
    }

    public static int count() { return numVideo; }
}
