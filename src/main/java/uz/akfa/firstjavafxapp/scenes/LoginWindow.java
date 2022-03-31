package uz.akfa.firstjavafxapp.scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginWindow extends Application {

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene scene =new Scene(fxmlLoader.load(), 800,500);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();

        mainStage = stage;
    }



}
