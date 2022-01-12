package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ViewVehicleController {
    public AnchorPane viewVehicleContext;
    public TableView viewVehicleTbl;
    public TableColumn colVehicleNo;
    public TableColumn colvehicleType;
    public TableColumn colMaxWeight;
    public TableColumn colNoOfPassengers;


    public void initialize(){
        viewVehicleTbl.setItems(FXCollections.observableArrayList(AddVehicleController.vehicleList));
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colvehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colMaxWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));
    }

}
