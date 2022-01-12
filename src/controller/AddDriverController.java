package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Drivers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AddDriverController {
    public AnchorPane AddDriverContext;
    public JFXTextField txtDName;
    public JFXTextField txtDNIC;
    public JFXTextField txtDliceneNo;
    public JFXTextField txtDAddress;
    public JFXTextField txtDContact;

    static ArrayList<Drivers> driverArrayList =new ArrayList();


    public void moveToNIC(ActionEvent actionEvent) {
        txtDNIC.requestFocus();
    }

    public void moveToLiceneNo(ActionEvent actionEvent) {
        txtDliceneNo.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtDAddress.requestFocus();
    }

    public void moveToContact(ActionEvent actionEvent) {
        txtDContact.requestFocus();
    }

    public void addDriver(ActionEvent actionEvent) {
        Drivers driver = new Drivers(txtDName.getText(),txtDNIC.getText(),txtDliceneNo.getText(),txtDAddress.getText(),Integer.parseInt(txtDContact.getText()));
        txtDName.clear();
        txtDNIC.clear();
        txtDliceneNo.clear();
        txtDAddress.clear();
        txtDContact.clear();
        if (driverArrayList.add(driver)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
        }
    }

    public void viewDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        AddDriverContext.getChildren().clear();
        AddDriverContext.getChildren().add(load);
    }
}
