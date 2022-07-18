package WordOccurrences;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ParseGUILaucher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PoemParse_FXML.fxml"));

        primaryStage.setTitle("Poem Parse");
        AnchorPane layout = new AnchorPane();
        Button submitBtn = new Button("Submit");
        TextField file_Input = new TextField("Field");
        TextArea file_Output = new TextArea("Area");

        layout.getChildren().add(submitBtn);
        layout.getChildren().add(file_Input);
        layout.getChildren().add(file_Output);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
