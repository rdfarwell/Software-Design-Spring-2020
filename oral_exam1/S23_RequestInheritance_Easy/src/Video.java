/**
 * Object class Video is a data type that has a url, title, and creator
 *
 * @author Dean Farwell
 */
public class Video {

    /**
     * String that indicates the location of the video
     */
    private String url;

    /**
     * String that indicates the title of the video
     */
    private String title;

    /**
     * String that indicates the name of the creator of the video
     */
    private String name;

    /**
     * Constructor for the Video object. Adds the url, title, and name upon creation
     * @param url Location of the video
     * @param title Name of the video
     * @param name Creator of the video
     */
    public Video(String url, String title, String name) {
        this.url = url;
        this.title = title;
        this.name = name;
    }

    /**
     * Getter for url
     * @return The video's url
     */
    public String getURL() {
        return url;
    }

    /**
     * Getter for the title of the video
     * @return The video's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the creator of the video
     * @return The video's creator
     */
    public String getName() {
        return name;
    }

}
