import java.util.Map;
import java.util.UUID;

public class PostFormRequest extends PostRequest {

    protected Form form;
    protected static int numForm;

    public PostFormRequest(UUID id, String ip, Form form) {
        super(id, ip);
        this.form = form;
        numForm++;
    }

    @Override
    public String toString(Request req) {
        System.out.println(super.toString(req));
        System.out.println("Form Data");

        for(Map.Entry mapElement : form.getFields().entrySet()) {
            System.out.println("Label: " + mapElement.getKey());
            System.out.println("Value: " + mapElement.getValue());
        }

        return "";
    }

    public static int count() {
        return numForm;
    }
}
