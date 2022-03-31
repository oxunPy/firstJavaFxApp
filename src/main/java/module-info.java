module uz.akfa.firstjavafxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires com.fasterxml.jackson.databind;


    opens uz.akfa.firstjavafxapp to javafx.fxml;
    exports uz.akfa.firstjavafxapp;
    exports uz.akfa.firstjavafxapp.controller;
    opens uz.akfa.firstjavafxapp.controller to javafx.fxml;
    exports uz.akfa.firstjavafxapp.scenes;
    opens uz.akfa.firstjavafxapp.scenes to javafx.fxml;
}