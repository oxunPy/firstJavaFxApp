package uz.akfa.firstjavafxapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.HelloApplication;
import uz.akfa.firstjavafxapp.scenes.LoginWindow;

public class HelloController {
    @FXML
    private Label welcomeText;

    public Label getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(Label welcomeText) {
        this.welcomeText = welcomeText;
    }

    @FXML
    protected void onHelloButtonClick() throws InterruptedException {
        welcomeText.setText("Welcome to JavaFX Application!");
        Thread.sleep(1000L);

        HelloApplication helloApplication = new HelloApplication();
        helloApplication.setCurrentWindow("/fxml/login.fxml");

    }
}