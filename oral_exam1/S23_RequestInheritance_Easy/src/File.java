/**
 * File data type that contains filepath and file type components. Class contains three public methods
 *
 * @author Dean Farwell
 */
public class File {

    /**
     * Filepath of the File
     */
    private String path;

    /**
     * File type of the File
     */
    private String type;

    /**
     * Constructor for File that initializes the file path and file type
     * @param path File path String to be added to File
     * @param type File type String to be added to File
     */
    public File(String path, String type) {
        this.path = path;
        this.type = type;
    }

    /**
     * Getter for path of a File
     * @return Path of a File
     */
    public String getPath() {
        return path;
    }

    /**
     * Getter for type of a file
     * @return Type of a File
     */
    public String getType() {
        return type;
    }

}
