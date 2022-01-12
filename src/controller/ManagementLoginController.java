package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginController {
    public JFXTextField managementName;
    public JFXPasswordField managementPassword;
    public AnchorPane loginContext;
    public javafx.scene.control.Label Label;

    public void goToPassword(ActionEvent actionEvent) {
        managementPassword.requestFocus();
    }

    public void goToTasks(ActionEvent actionEvent) throws IOException {
        if(managementPassword.getText().equals("1234") & managementName.getText().equalsIgnoreCase("Admin")){
            URL resource = getClass().getResource("../view/Details.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
        else{
            Label.setText("Enter correct username or password");
        }
    }

    public void goToHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomePage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
