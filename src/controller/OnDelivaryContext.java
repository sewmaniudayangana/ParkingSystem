package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.OnDeliveryVehiclesTM;

public class OnDelivaryContext {
    public AnchorPane onDelivaryContext;

    public static ObservableList<OnDeliveryVehiclesTM> onDeliveryVehiclesTMObservableList = FXCollections.observableArrayList();
    public TableView TblDelivery;
    public TableColumn colVNo;
    public TableColumn colVType;
    public TableColumn colDName;
    public TableColumn colTime;

    public void initialize(){
        TblDelivery.setItems(onDeliveryVehiclesTMObservableList);
        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));
    }
}
