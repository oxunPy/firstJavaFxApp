package uz.akfa.firstjavafxapp.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uz.akfa.firstjavafxapp.StudentsData.Students;
import uz.akfa.firstjavafxapp.models.*;
import uz.akfa.firstjavafxapp.scenes.EditConfirmWindow;
import uz.akfa.firstjavafxapp.scenes.EditWindow;
import uz.akfa.firstjavafxapp.scenes.HomepageWindow;
import uz.akfa.firstjavafxapp.scenes.LoginWindow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class HomepageController {



    public interface CloseListener{
        void onClose();
    }

    @FXML
    Label userDetails;

    @FXML
    Button add;

    @FXML
    Button delete;

    @FXML
    Button edit;

    @FXML
    public TableView<Student> tableView;

    @FXML
    TableColumn<Student, String> col_id;

    @FXML
    TableColumn<Student, String> col_firstName;

    @FXML
    TableColumn<Student, String> col_lastName;

    @FXML
    TableColumn<Student, String> col_role;

    public static Student editingStudent;

    public CloseListener closeListener = new CloseListener() {
        @Override
        public void onClose() {
            tableView.refresh();
        }
    };

    final static ObservableList<Student> data = FXCollections.observableArrayList(
            Students.getStudentList()
    );

    @FXML
    public void initialize() {
        userDetails.setText(LoginController.getStudent().getFirstName());

//        TableView<Student> table = new TableView<Student>();

//        tableView.setItems(data);

        tableView.setOnMousePressed(e ->{
            tableView.setItems(data);
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            col_id.setCellValueFactory(cellData -> new SimpleStringProperty(Long.toString(cellData.getValue().getId())));
            col_firstName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
            col_lastName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
            col_role.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRole().toString()));
        });


        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    protected void onBackBtnClick() throws Exception {
        new LoginWindow().start(new Stage());
        HomepageWindow.mainStage.close();
    }

    private void editBtnClick(EditType editType) throws Exception {
        EditConfirmWindow editWindow = new EditConfirmWindow(closeListener);
        editWindow.setEditType(editType);
        System.out.println(editType);
        editWindow.start(new Stage());
    }


    @FXML
    protected void onAddBtnClick() throws Exception {

        editBtnClick(EditType.ADD);
//        HomepageWindow.mainStage.close();
//        Students.getStudentList().add(student);

    }

    @FXML
    protected void onDeleteBtnClick() throws Exception {
//        HomepageWindow.mainStage.close();

        EditConfirmWindow editConfirmWindow = new EditConfirmWindow();
        editConfirmWindow.setEditType(EditType.DELETE);
        editConfirmWindow.start(new Stage());

        // deleting selected items
        List<Student> selectedItems = tableView.getSelectionModel().getSelectedItems();
        selectedItems.stream().forEach(student -> student.setStatus(Status.DELETED));
        data.removeAll(selectedItems);
//        new HomepageWindow().start(HomepageWindow.mainStage);
//        EditConfirmWindow.mainStage.close();
    }


    @FXML
    protected void onEditBtnClick() throws Exception {
        editingStudent = tableView.getSelectionModel().getSelectedItem();

        editBtnClick(EditType.EDIT);
    }

    public void autoResizeColumns(TableView<?> table) {
        //Set the right policy
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.getColumns().stream().forEach((column) ->
        {
            //Minimal width = columnheader
            Text t = new Text(column.getText());
            double max = t.getLayoutBounds().getWidth();
            for (int i = 0; i < table.getItems().size(); i++) {
                //cell must not be empty
                if (column.getCellData(i) != null) {
                    t = new Text(column.getCellData(i).toString());
                    double calcwidth = t.getLayoutBounds().getWidth();
                    //remember new max-width
                    if (calcwidth > max) {
                        max = calcwidth;
                    }
                }
            }
            //set the new max-widht with some extra space
            column.setPrefWidth(max + 10.0d);
        });
    }


}
