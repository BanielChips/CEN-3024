package PoemPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <b>Word Occurrences</b>
 * Program to take in a txt file, parse it for Strings,
 * then outputs those Strings and their frequency of
 * occurence in decending order.
 * <p>
 * Program operates using a basic GUI consisting of
 * an entry field with a button and output field.
 * <p>
 * <b>Important note:</b>
 * This file is the module 6 assignment copy of the
 * Word Occurrences program, PoemParse. I completed
 * modules 6 GUI and 7 Testing using different copies
 * of the application. However, all attempts at
 * combinging the two copies have failed as javafx
 * hates me and I do not know why. This means that
 * this copy of the program does <b>not</b> include
 * testing functionality and is not abstracted into
 * multiple methods, it is just the one big method.
 * I will probably have to use this code for the
 * remaining module and final, which I apologize for.
 * <p>
 * More information on the program life cycle can be
 * found within the documentation readme within the
 * project file, PoemPackage.Documentation.md
 * 
 * @author Daniel Reecy
 * @version 4 - module 9
 */
public class PoemParseFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PoemParseGUI.fxml"));

        primaryStage.setTitle("Poem Parse");
        AnchorPane layout = new AnchorPane();
        Button submitBtn = new Button("Submit");
        TextField file_Input = new TextField("Field");
        TextArea file_Output = new TextArea("Area");

        layout.getChildren().add(submitBtn);
        layout.getChildren().add(file_Input);
        layout.getChildren().add(file_Output);

        Scene scene = new Scene(root, 420, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
