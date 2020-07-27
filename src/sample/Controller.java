package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    Model model = new Model();

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void buttonPressed(Event event) {
        Button b = (Button) event.getSource();
        System.out.println("Button pressed: " + b.getText());
    }

    public void listFiles (Event event) {
        String command = "ls /home/ma/";
        Button b = (Button) event.getSource();
        model.executeShellCommand(command);
    }

}
