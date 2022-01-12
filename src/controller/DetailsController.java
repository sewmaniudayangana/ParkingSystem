package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DetailsController {
    public AnchorPane detailsContext;
    public AnchorPane windowContext;

    public void goToViewInsideVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/InParking.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void goToOutsideVehicles(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OnDelivary.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void goToAddVehicles(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void goToAddDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }


    public void goToHomePage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomePage.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) windowContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
