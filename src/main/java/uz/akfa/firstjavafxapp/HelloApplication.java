package uz.akfa.firstjavafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public String getCurrentWindow() {
        return currentWindow;
    }

    public void setCurrentWindow(String currentWindow) {
        this.currentWindow = currentWindow;
    }

    private String currentWindow = "hello-view.fxml";

    @Override
    public void start(Stage stage) throws IOException {             // getResource("style.css") is applicable.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(currentWindow));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("homepage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}