package PoemPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class ParseController {

    @FXML
    private TextField file_Input;
    @FXML
    private TextArea file_Output;
    @FXML
    private Button submitButton;

    public String filePath;

    public void submit(ActionEvent event) {
        try {
            filePath = file_Input.getText();
            file_Output.setText(PoemParse_Sorter.fileFreqSort(filePath));
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
