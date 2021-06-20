package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        primaryStage.setTitle("Tasks");
        primaryStage.setScene(new Scene(root, 440, 275));
        primaryStage.show();

        Parent root2 = FXMLLoader.load(getClass().getResource("TOdo.fxml"));
        Stage stage = new Stage();
        stage.setTitle("TODo");
        stage.setScene(new Scene(root2,440,275));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
