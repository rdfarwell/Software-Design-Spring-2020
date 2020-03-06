import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * Class that randomly creates various data for use in Server
 *
 * @author Given Class
 */
class DataGenerator {

    /**
     * Random instance to create random numbers
     */
    private Random rand;

    /**
     * An array of names
     */
    private String[] names;

    /**
     * An array of encryption methods
     */
    private String[] encryption;

    /**
     * An array of video titles
     */
    private String[] videoTitles;

    /**
     * An array of file paths
     */
    private String[] filePaths;

    /**
     * An array of file types
     */
    private String[] fileTypes;

    /**
     * An array of colors
     */
    private String[] colors;

    /**
     * Constructor for DataGenerator that initializes all of the private variables with various strings
     */
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    /**
     * Pulls a random name
     * @return A random name
     */
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /**
     * Pulls a random color
     * @return A random color
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /**
     * Pulls a random video title
     * @return A random video title
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /**
     * Pulls a random file type
     * @return A random file type
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /**
     * Pulls a random file path
     * @return A random file path
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    /**
     * Creates a random URL
     * @return A random URL
     */
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /**
     * Creates a random payment amount
     * @return A random payment amount
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /**
     * Creates a random UUID
     * @return A random UUID
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /**
     * Pulls a random encryption scheme
     * @return A random encryption scheme
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /**
     * Creates a random video
     * @return A random video
     */
    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /**
     * Creates a random file
     * @return A random file
     */
    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /**
     * Creates a random form
     * @return A random form
     */
    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /**
     * Creates a random IP
     * @return A random IP
     */
    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }

}