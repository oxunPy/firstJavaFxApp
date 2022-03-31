package uz.akfa.firstjavafxapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.StudentsData.Students;
import uz.akfa.firstjavafxapp.models.EditType;
import uz.akfa.firstjavafxapp.models.Role;
import uz.akfa.firstjavafxapp.models.Student;
import uz.akfa.firstjavafxapp.scenes.EditConfirmWindow;
import uz.akfa.firstjavafxapp.scenes.EditWindow;
import uz.akfa.firstjavafxapp.scenes.HomepageWindow;
import uz.akfa.firstjavafxapp.scenes.LoginWindow;

public class EditConfirmController {

    public Text getUsername() {
        return username;
    }

    public void setUsername(Text username) {
        this.username = username;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public HomepageController.CloseListener getListener() {
        return listener;
    }

    public void setListener(HomepageController.CloseListener listener) {
        this.listener = listener;
    }

    @FXML
    Text username;

    @FXML
    TextField login;

    @FXML
    PasswordField password;

    public HomepageController.CloseListener listener;


    public void onSubmitBtnClick(ActionEvent actionEvent) throws Exception {

        if(login.getText().isEmpty() || password.getText().isEmpty()){
            System.out.println("login or password is empty");
        }
        Student student = new Student(login.getText(), password.getText());

         if(LoginController.getStudent().equals(student)){
            if(EditConfirmWindow.getEditType().equals(EditType.DELETE)){    // deleting
                new HomepageWindow().start(HomepageWindow.mainStage);
                EditConfirmWindow.mainStage.close();
            }
            else{           // EditType == ADD or EDIT
                new EditWindow(getListener()).start(new Stage());
                EditConfirmWindow.mainStage.close();
            }
        }
        else{
            System.out.println("Incorrect password or login!");
        }
    }

    @FXML
    protected void onBackBtnClick() throws Exception {
//        new HomepageWindow().start(new Stage());
        EditConfirmWindow.mainStage.close();
    }

    @FXML
    public void initialize(){
        username.setText(LoginController.getStudent().getFirstName());
    }
}
