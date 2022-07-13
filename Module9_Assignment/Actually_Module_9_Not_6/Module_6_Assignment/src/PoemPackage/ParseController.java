package PoemPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 * Controller class for the Word Occurrences, PoemParse, GUI.
 * It is a simple action controller to use the textField as
 * input for the application and the textArea as output.
 * 
 * @author Daniel Reecy
 * @version 4 - module 9
 */
public class ParseController {

    @FXML
    private TextField file_Input;
    @FXML
    private TextArea file_Output;
    @FXML
    private Button submitButton;

    public String filePath;

    /**
     * Action controller for button press.
     * <p>
     * Inteded for when a valid file path to
     * the poem txt file is typed into the
     * textField.
     * 
     * @param event Button press to signal the file path is entered
     *              into the field.
     */
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
