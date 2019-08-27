import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    private Model model = new Model();
    private long result;

    @FXML
    private Text output;

    private String operator = "";
    private boolean start = true;

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processClear(ActionEvent event) {

        output.setText("");

    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            model.setNumber1(Long.parseLong(output.getText()));
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;

            model.setNumber2(Long.parseLong(output.getText()));
            result = model.calculate(operator);
            output.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }
}
