import java.util.UUID;

/**
 * GetVideoRequest object that extends GetRequest and adds a video data type. Has a constructor and two public methods
 * @see GetRequest
 *
 * @author Dean Farwell
 */
public class GetVideoRequest extends GetRequest {

    /**
     * Video of the GetVideoRequest
     */
    private Video video;

    /**
     * Total number of GetVideoRequests
     */
    private static int numVideo;

    /**
     * Constructor of GetVideoRequest that initializes the UUID, URL, and Video
     * @param id UUID to be added to the GetVideoRequest
     * @param video Video to be added to the GetVideoRequest
     */
    public GetVideoRequest(UUID id, Video video) {
        super(id, video.getURL());
        this.video = video;
        numVideo++;
    }

    /**
     * Override of GetRequest's toString to output each component of the GetVideoRequest object
     * @return Prints each component of GetVideoRequest, and returns an empty string
     */
    @Override
    public String toString() {
        System.out.println(super.toString());
        System.out.println("Video: " + video.getTitle());
        System.out.print("By: " + video.getName());
        return "";
    }

    /**
     * Return the total number of GetVideoRequests created
     * @return Total number of GetVideoRequests created
     */
    public static int count() { return numVideo; }
}
