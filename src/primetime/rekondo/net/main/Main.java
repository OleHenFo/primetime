package primetime.rekondo.net.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage window;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PrimeTimeGui.fxml"));
        window = primaryStage;
        window.setTitle("Prime Time");
        window.setScene(new Scene(root));
        window.show();
    }

    private void buildPrimeScene(Scene scene){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
