package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Button button = new Button("Click me!");
    private TextField textField = new TextField();
    private TextField textField2 = new TextField();
    private ToggleGroup buttonGroup = new ToggleGroup();
    private RadioButton upperCaseButton = new RadioButton("Upper Case");
    private RadioButton lowerCaseButton = new RadioButton("Lower Case");
    private FlowPane pane = new FlowPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Organiser 1.0");

        buttonGroup.getToggles().add(upperCaseButton);
        buttonGroup.getToggles().add(lowerCaseButton);

        pane.getChildren().add(button);
        pane.getChildren().add(textField);
        pane.getChildren().add(upperCaseButton);
        pane.getChildren().add(lowerCaseButton);
        pane.getChildren().add(textField2);

        button.setOnAction(event->{
            if (textField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("No text!");
                alert.setContentText("Please put text into initial field");
                alert.show();
            }
            else {
                RadioButton tempButton = (RadioButton) buttonGroup.getSelectedToggle();
                if(tempButton.getText().equals(upperCaseButton.getText())) {
                    textField2.setText(textField.getText().toUpperCase());
                } else if (tempButton.getText().equals(lowerCaseButton.getText())) {
                    textField2.setText(textField.getText().toLowerCase());
                }
            }
        });


        primaryStage.setScene(new Scene(pane,300,300));
        primaryStage.show();
    }
}
