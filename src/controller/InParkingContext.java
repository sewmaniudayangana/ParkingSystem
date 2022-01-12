package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.ParkedVehiclesTM;

public class InParkingContext {
    public AnchorPane inParkinContext;

    public static ObservableList<ParkedVehiclesTM> parkedVehiclesTMObservableList = FXCollections.observableArrayList();
    public TableView ParkingTbl;
    public TableColumn colVNo;
    public TableColumn colVType;
    public TableColumn colVSlot;
    public TableColumn colVTime;

    public void initialize(){
        ParkingTbl.setItems(parkedVehiclesTMObservableList);
        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colVTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
    }
}
