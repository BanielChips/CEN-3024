package WordOccurrences;

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
            database_controller.createTable();
        } catch (Exception e) {
            System.out.println("Table creation error on submit:" + e);
        }

        try {

            filePath = file_Input.getText();
            PoemParse_Sorter.poemSorter(filePath);

            // mapToString ends up working here for converting DB contents to String
            file_Output.setText(PoemParse_Sorter.mapToString(database_controller.read()));

        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
