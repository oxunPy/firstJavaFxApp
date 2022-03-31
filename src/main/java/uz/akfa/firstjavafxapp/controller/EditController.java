package uz.akfa.firstjavafxapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.StudentsData.LineBasedJsonWrite;
import uz.akfa.firstjavafxapp.StudentsData.Students;
import uz.akfa.firstjavafxapp.models.EditType;
import uz.akfa.firstjavafxapp.models.Role;
import uz.akfa.firstjavafxapp.models.Status;
import uz.akfa.firstjavafxapp.models.Student;
import uz.akfa.firstjavafxapp.scenes.EditConfirmWindow;
import uz.akfa.firstjavafxapp.scenes.EditWindow;

public class EditController {
    @FXML
    Label username;

    @FXML
    TextField id;

    @FXML
    TextField firstName;

    @FXML
    TextField lastName;

    @FXML
    TextField role;

    public void setListener(HomepageController.CloseListener listener) {
        this.listener = listener;
    }

    public HomepageController.CloseListener listener;

    // if editType is edit, we have to delete or disable existing Student with this id then add the updated one.
    private void onSubmitBtnClickEdit() {

        Student editingStudent = HomepageController.editingStudent;
//        Student student = new Student(Long.valueOf(id.getText()),
//                firstName.getText(), lastName.getText(), Role.decode(role.getText()), HomepageController.editingStudent.getPassword());
        Student student = Students.getStudentList().stream()
                .filter(item -> item.getId().equals(Long.valueOf(id.getText())) && item.getFirstName().equals(firstName.getText()))
                .findFirst().orElse(null);


        if (editingStudent.equals(student)) {       // updating from our database - is last way
            // update selected row columns, send student to homepageController
            student.setLastName(lastName.getText());
            student.setRole(Role.decode(role.getText()));

            HomepageController.editingStudent = student;
            System.out.println(editingStudent);

        } else {
            student = new Student(Long.valueOf(id.getText()),
                    firstName.getText(), lastName.getText(), Role.decode(role.getText()), HomepageController.editingStudent.getPassword());
            HomepageController.editingStudent.setStatus(Status.DELETED);
            HomepageController.data.remove(editingStudent);
//            Students.getStudentList().add(student);
            if (HomepageController.data.add(student)) {
                LineBasedJsonWrite.write(student, Students.getFileWriter());
            }
        }

        if (listener != null)
            listener.onClose();

    }

    @FXML
    public void onSubmitBtnClick(ActionEvent event) throws Exception {

        if (EditConfirmWindow.getEditType() == EditType.EDIT) { // editing stage
            onSubmitBtnClickEdit();
        } else {
            Student student = new Student(Long.valueOf(id.getText()),
                    firstName.getText(), lastName.getText(), Role.decode(role.getText()), "1234");
            if (HomepageController.data.add(student)) {
                LineBasedJsonWrite.write(student, Students.getFileWriter());
            }
        }


        EditWindow.mainStage.close();
//        new HomepageWindow().start(new Stage());
    }


    @FXML
    public void initialize() {
        if (EditConfirmWindow.getEditType() == EditType.EDIT) {
            Student s = HomepageController.editingStudent;
            username.setText(s.getFirstName());
            id.setText(s.getId().toString());
            firstName.setText(s.getFirstName());
            lastName.setText(s.getLastName());
            role.setText(s.getRole().getCode());
        }
    }

    @FXML
    protected void onBackBtnClick() throws Exception {
        new EditConfirmWindow().start(new Stage());
        EditWindow.mainStage.close();
    }
}
