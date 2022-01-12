package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static controller.HomePageController.vehicleList;

public class AddVehicleController {

    public AnchorPane AddVehicleContext;
    public JFXTextField vehicleNo1;
    public JFXComboBox vehicleCmb1;
    public JFXTextField maxWeight1;
    public JFXTextField noOfPassengers1;

    private String vehicleType;

    static ArrayList<Vehicle> vehicleList = new ArrayList();

    public void initialize(){
        vehicleCmb1.getItems().addAll("Van","Bus","Cargo Lorry");
    }

    public void moveToVehicleType(ActionEvent actionEvent) {
        vehicleCmb1.requestFocus();
    }

    public void moveToMaxWeight(ActionEvent actionEvent) {
        maxWeight1.requestFocus();
    }

    public void moveToNoOfPassengers(ActionEvent actionEvent) {
        noOfPassengers1.requestFocus();
    }

    public void addVehicle(ActionEvent actionEvent) {
        try {

            if(vehicleCmb1.getSelectionModel().getSelectedItem().toString().equals("Van")){
                Van van = new Van(vehicleNo1.getText(),vehicleCmb1.getValue().toString(),Integer.parseInt(noOfPassengers1.getText()),Integer.parseInt(maxWeight1.getText()));
                vehicleNo1.clear();
                vehicleCmb1.getSelectionModel().clearSelection();
                noOfPassengers1.clear();
                maxWeight1.clear();
                if (vehicleList.add(van)){
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
                }
            }

            if(vehicleCmb1.getSelectionModel().getSelectedItem().toString().equals("Bus")){
                Bus bus = new Bus(vehicleNo1.getText(),vehicleCmb1.getValue().toString(),Integer.parseInt(noOfPassengers1.getText()),Integer.parseInt(maxWeight1.getText()));
                vehicleNo1.clear();
                vehicleCmb1.getSelectionModel().clearSelection();
                noOfPassengers1.clear();
                maxWeight1.clear();
                if (vehicleList.add(bus)){
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
                }
            }
            if(vehicleCmb1.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")){
                CargoLorry cargoLorry = new CargoLorry(vehicleNo1.getText(),vehicleCmb1.getValue().toString(),Integer.parseInt(noOfPassengers1.getText()),Integer.parseInt(maxWeight1.getText()));
                vehicleNo1.clear();
                vehicleCmb1.getSelectionModel().clearSelection();
                noOfPassengers1.clear();
                maxWeight1.clear();
                if (vehicleList.add(cargoLorry)){
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
                }else{
                    new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
                }
            }
        }catch (NullPointerException n){

        }
    }

    public void viewDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        AddVehicleContext.getChildren().clear();
        AddVehicleContext.getChildren().add(load);
    }
}
