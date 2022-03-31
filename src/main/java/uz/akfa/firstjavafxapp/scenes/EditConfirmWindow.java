package uz.akfa.firstjavafxapp.scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.controller.EditConfirmController;
import uz.akfa.firstjavafxapp.controller.HomepageController;
import uz.akfa.firstjavafxapp.models.EditType;

import java.io.IOException;

public class EditConfirmWindow extends Application {

    private static EditType editType;

    public static EditType getEditType() {
        return editType;
    }

    public void setEditType(EditType editType) {
        this.editType = editType;
    }

    public static Stage mainStage;
    public HomepageController.CloseListener listener;


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/confirm_view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 500);

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("EDIT_CONFIRM");
        stage.setScene(scene);
        stage.show();
        EditConfirmController confirmController = (EditConfirmController) fxmlLoader.getController();
        confirmController.setListener(listener);
        mainStage = stage;
    }

    public EditConfirmWindow(HomepageController.CloseListener listener) {
        this.listener = listener;
    }

    public EditConfirmWindow() {
    }
}
