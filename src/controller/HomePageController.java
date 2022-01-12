package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Drivers;
import model.Vehicle;
import view.tm.OnDeliveryVehiclesTM;
import view.tm.ParkedVehiclesTM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static controller.InParkingContext.parkedVehiclesTMObservableList;
import static controller.OnDelivaryContext.onDeliveryVehiclesTMObservableList;

public class HomePageController {
    public AnchorPane homePageContext;
    public JFXComboBox<String> vehicleTypeCmb;
    public JFXTextField txtVehicleType;
    public JFXComboBox<String> driverCmb;
    public TextField Date;
    public TextField Time;
    public JFXTextField slotNo;
    public JFXButton parkBtn;
    public JFXButton deliveryBtn;
    private int minute;
    private int hour;
    public int second;

    static ArrayList<Drivers> driverArrayList = new ArrayList();
    static ArrayList<Vehicle> vehicleList = new ArrayList();

    public void initialize(){
        for (Vehicle temp:vehicleList) {
            vehicleTypeCmb.getItems().add(temp.getVehicleNo());
        }

        vehicleTypeCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            slotNo.clear();
            vehicleTypeCmb.setAccessibleText(newValue);
            for (Vehicle temp:vehicleList) {
                if(newValue.equals(temp.getVehicleNo())){
                    txtVehicleType.setText(temp.getVehicleType());
                    disableAndEnable(vehicleTypeCmb.getValue().toString());
                    if(!parkBtn.isDisable()){
                        try {
                            slotNo.setText(temp.park(temp.getVehicleNo(),temp.getVehicleType())+"");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        for (Drivers d:driverArrayList) {
            driverCmb.getItems().add(d.getName());
        }

        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    second = cal.get(Calendar.SECOND);
                    minute = cal.get(Calendar.MINUTE);
                    hour = cal.get(Calendar.HOUR_OF_DAY);

                    Time.setText(hour + ":" + (minute) + ":" + second);

                    String state=null;
                    if(hour>=12){
                        state="PM";
                    }else{
                        state="AM";
                    }
                    Time.setText("    "+String.format("%02d", hour)+ ":" +String.format("%02d", minute)+ ":" + String.format("%02d", second)+" "+state);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        //...
                    }
                }
            }
        };
        clock.start();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = new Date();
        Date.setText(dateFormat.format(date));
    }

    public void parkingVehicles(ActionEvent actionEvent) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            ParkedVehiclesTM parkedVehiclesTM = new ParkedVehiclesTM(vehicleTypeCmb.getValue().toString()
                    ,txtVehicleType.getText(),Integer.parseInt(slotNo.getText())
                    ,java.time.LocalDateTime.now().format(dateTimeFormatter)
            );
            parkedVehiclesTMObservableList.add(parkedVehiclesTM);
            slotNo.clear();
        }catch (Exception e){

        }
    }

    public void goToManagementLogIn(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) homePageContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void disableAndEnable(String vehicleNo){
        parkBtn.setDisable(false);
        deliveryBtn.setDisable(false);
        for (ParkedVehiclesTM temp:parkedVehiclesTMObservableList) {
            if(temp.getVehicleNo().equals(vehicleNo)){
                parkBtn.setDisable(true);
            }
        }
        if(!parkBtn.isDisable()){
            deliveryBtn.setDisable(true);
        }
    }
    public void onDeliveryShift(ActionEvent actionEvent) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            parkedVehiclesTMObservableList.removeIf(temp -> temp.getVehicleNo().equals(vehicleTypeCmb.getValue().toString()));
            OnDeliveryVehiclesTM onDeliveryVehiclesTM = new OnDeliveryVehiclesTM(vehicleTypeCmb.getValue().toString(),
                    txtVehicleType.getText(),driverCmb.getValue().toString(),
                    java.time.LocalDateTime.now().format(dateTimeFormatter));
            onDeliveryVehiclesTMObservableList.add(onDeliveryVehiclesTM);
        }catch (Exception e){

        }
    }
}
