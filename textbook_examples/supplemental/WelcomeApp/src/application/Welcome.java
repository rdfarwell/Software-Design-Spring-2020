package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;


public class Welcome extends Application {
    private Stage primaryStage;
    private VBox rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Welcome to JavaFX");

        try {
            FXMLLoader loader = new FXMLLoader();
            final URL test = Welcome.class.getResource("Welcome.fxml");
            loader.setLocation(test);
            this.rootLayout = (VBox) loader.load();

            final Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
