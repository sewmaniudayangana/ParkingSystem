package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class ViewDriverController {
    public AnchorPane viewDriverContext;
    public TableView driverTbl;
    public TableColumn colName;
    public TableColumn colnic;
    public TableColumn collceneno;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colAddress1;


    public void initialize(){
        driverTbl.setItems(FXCollections.observableArrayList(AddDriverController.driverArrayList));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colnic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        collceneno.setCellValueFactory(new PropertyValueFactory<>("liceneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

    }
}
