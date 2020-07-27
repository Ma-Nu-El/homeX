package sample;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    Model model = new Model();
    String command;

    // this is the view
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show(); //enable view
    }

    public void listFiles () {
        command = "ls /home/ma/bin";
        System.out.println(model.getShellOutput(command));
    }

    public void exit () {
        System.exit(0); // don't want to exit immediately
    }

}
