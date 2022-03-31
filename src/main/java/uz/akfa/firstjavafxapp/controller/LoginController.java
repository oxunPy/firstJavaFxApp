package uz.akfa.firstjavafxapp.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.StudentsData.Students;
import uz.akfa.firstjavafxapp.models.Student;
import uz.akfa.firstjavafxapp.scenes.HomepageWindow;
import uz.akfa.firstjavafxapp.scenes.LoginWindow;

import java.util.ArrayList;
import java.util.List;

public class LoginController{
    @FXML
    Button btnSubmit;
    @FXML
    PasswordField pfPassword;
    @FXML
    TextField tfLogin;


    public static Student getStudent() {
        return student;
    }

    private static Student student;

    public Button getBtnSubmit() {
        return btnSubmit;
    }

//    public void setBtnSubmit(Button btnSubmit) {
//        this.btnSubmit = btnSubmit;
//    }

    public PasswordField getPfPassword() {
        return pfPassword;
    }

//    public void setPfPassword(PasswordField pfPassword) {
//        this.pfPassword = pfPassword;
//    }

    public TextField getTfLogin() {
        return tfLogin;
    }

//    public void setTfLogin(TextField tfLogin) {
//        this.tfLogin = tfLogin;
//    }

    @FXML
    protected void onBtnSubmitClick() throws Exception {

        if(tfLogin.getText().isEmpty() || pfPassword.getText().isEmpty()){
            System.out.println("login or password is empty");
        }
        student = new Student(tfLogin.getText(), pfPassword.getText());
        System.out.println(student);
        if(Students.getStudentList().contains(student)){
            new HomepageWindow().start(new Stage());
            LoginWindow.mainStage.close();

            // set label of homepage with username

        }
    }

}