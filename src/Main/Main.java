package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import Controller.Controller;

public class Main extends Application {

    // example of GUI application
    // https://www.youtube.com/watch?v=_IYN9tiK6tU&list=PLfu_Bpi_zcDNYL6171Op3S1ABtuyFV7Nr&index=18
    // Source for JavaFX
    // https://www.javatpoint.com/javafx-tutorial

    Controller controller = new Controller();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        controller.start(stage);
    }
}
