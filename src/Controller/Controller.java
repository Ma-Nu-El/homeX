package Controller;

import Model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    Model model = new Model();
    String command;

    // this is the view
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/mainMenu.fxml"));
        primaryStage.setTitle("HomeX");
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show(); //enable view
    }

    public void install () {
        command = "/home/ma/home/bin/deploy install";
        System.out.println(model.getShellOutput(command));
    }

    public void uninstall () {
        command = "/home/ma/bin/deploy uninstall";
        System.out.println(model.getShellOutput(command));
    }

    public void updateSubmodules () {
        command = "/home/ma/bin/updateSubmodules --home";
        System.out.println(model.getShellOutput(command));
    }

    public void exit () {
        System.exit(0);
    }

}
