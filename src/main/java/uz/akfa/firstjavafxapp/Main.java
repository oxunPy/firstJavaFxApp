//package uz.akfa.firstjavafxapp;
//
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.TilePane;
//import javafx.scene.shape.Arc;
//import javafx.scene.shape.Line;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.FileInputStream;
//import java.util.Objects;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        try{
//            // set title
//            primaryStage.setTitle("new Button and its action handler");
//            // create new button shape
//            Button btn = new Button();
//            // set text inside button
//            btn.setText("Display message");
//            // set action Listener
//            btn.setOnAction(new EventHandler(){
//
//                @Override
//                public void handle(Event event){
//                    // instruction executed when the button is pressed.
//                    System.out.println("Hi there! You clicked me!");
//                }
//            });
//
//            // adding text-field
//            TextField textField = new TextField();
//            Button button = new Button();
//            button.setText("Submit");
//            button.setOnAction(new EventHandler(){
//
//                @Override
//                public void handle(Event event) {
//                    System.out.println(textField.getText());
//                }
//            });
//
//
//            // read image as stream
//            FileInputStream input = new FileInputStream("C:/images.camera.png");
//            // prepare image object
//            Image image = new Image(input);
//            // create image-view object
//            ImageView imageView = new ImageView(image);
//
//            // javafx slider field
//            Slider slider = new Slider(0, 100, 0);
//
//            slider.valueProperty().addListener((observableValue, oldValue, newValue) -> System.out.println(slider.getValue()));
//
//
//            //javafx radio button
//            RadioButton radioButton1 = new RadioButton("Option 1");
//            RadioButton radioButton2 = new RadioButton("Option 2");
//            RadioButton radioButton3 = new RadioButton("Option 3");
//
//            // javafx toggle-group
//            ToggleGroup toggleGroup = new ToggleGroup();
//            radioButton1.setToggleGroup(toggleGroup);
//            radioButton2.setToggleGroup(toggleGroup);
//            radioButton3.setToggleGroup(toggleGroup);
//
//            Button buttonHandler = new Button("Submit");
//            buttonHandler.setOnAction(event ->{
//                System.out.println("is option 1 selected " + radioButton1.isSelected());
//                System.out.println("is option 2 selected " + radioButton2.isSelected());
//                System.out.println("is option 3 selected " + radioButton3.isSelected());
//            });
//
//
//            // ActionListener for radioButton
//            radioButton1.setOnAction(action -> {
//                System.out.println("is option 1 selected " + radioButton1.isSelected());
//            });
//
//
//            // password field javafx
//            PasswordField passwordField = new PasswordField();
//            Button btnPassword = new Button("Submit");
//            btnPassword.setOnAction(actionEvent -> {
//                System.out.println("Password entered " + passwordField.getText());
//            });
//
//            // javafx DataPicker
//            DatePicker datePicker = new DatePicker();
//            datePicker.setOnAction(new EventHandler<ActionEvent>(){
//                @Override
//                public void handle(ActionEvent actionEvent){
//                    System.out.println("date picked : " + datePicker.getValue());
//                }
//            });
//
//            // javafx checkbox
//            CheckBox checkBox = new CheckBox("check box");
//            checkBox.setOnAction(actionEvent -> {
//                System.out.println("Is checkBox selected " + checkBox.isSelected());
//            });
//
//            Label label = new Label("Label");
//
//            FileInputStream inputPicture = new FileInputStream("/pictures/camere2.png");
//            Image image2 = new Image(inputPicture);
//            ImageView imageView2 = new ImageView(image2);
//
//            // javafx label
//            Label labelPicture = new Label("Camera", imageView2);
//
//            // javafx hyperlink
//            Hyperlink hyperlink = new Hyperlink("www.google.com");
//            hyperlink.setOnAction(actionEvent ->{
//                System.out.println("hyperlink is clicked and visited :" + hyperlink.isVisited());
//            });
//
//            // javafx tooltip can be used some popup containing text when an user hover over a controller
//            Tooltip tooltip = new Tooltip("Creates a new file");
//            Button buttonUpload = new Button("upload");
//            buttonUpload.setTooltip(tooltip);
//
//                        //(x, y, width, height)
//            Rectangle rectangle = new Rectangle(10, 10, 40, 40);
//            // javafx line
//            Line line = new Line();
//            line.setStartX(10);
//            line.setStartY(10);
//            line.setEndX(50);
//            line.setEndY(50);
//
//            Group root = new Group();
//            root.getChildren().add(line);
//            line = new Line(30,30,50,50);
//            root.getChildren().add(line);
//
//
//            Arc arc = new Arc();
//            arc.setCenterX(10);
//            arc.setCenterY(10);
//            arc.setRadiusX(40);
//            arc.setRadiusY(60);
//            arc.setStartAngle(30);
//            arc.setLength(100);
//
//            // stack pane
//            TilePane tilePane = new TilePane();
//
//            tilePane.getChildren().add(checkBox);
//            tilePane.getChildren().add(textField);
//            tilePane.getChildren().add(button);
//            tilePane.getChildren().add(imageView);
//            tilePane.getChildren().add(radioButton1);
//            tilePane.getChildren().add(radioButton2);
//            tilePane.getChildren().add(radioButton3);
//            tilePane.getChildren().add(buttonHandler);
//            tilePane.getChildren().add(passwordField);
//            tilePane.getChildren().add(btnPassword);
//            tilePane.getChildren().add(datePicker);
//            tilePane.getChildren().add(label);
//            tilePane.getChildren().add(imageView2);
//            tilePane.getChildren().add(hyperlink);
//            tilePane.getChildren().add(buttonUpload);
//            Scene scene = new Scene(tilePane, 400, 400);
//            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("main.css")).toExternalForm());
//
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
