package uz.akfa.firstjavafxapp.scenes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.controller.EditConfirmController;
import uz.akfa.firstjavafxapp.controller.EditController;
import uz.akfa.firstjavafxapp.controller.HomepageController;

import java.io.IOException;

public class EditWindow extends Application {

    public static Stage mainStage;
    public HomepageController.CloseListener listener;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_update_view.fxml"));
        Scene scene = null;
        try {

            scene = new Scene(fxmlLoader.load(), 800,500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("EDIT");
        stage.setScene(scene);
        stage.show();
        EditController editController = fxmlLoader.getController();
        editController.setListener(listener);
        mainStage = stage;
    }

    public EditWindow(){}

    public EditWindow(HomepageController.CloseListener listener){
        this.listener = listener;
    }
}
