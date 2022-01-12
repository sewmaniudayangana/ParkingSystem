package model;

import java.io.IOException;

public class CargoLorry extends Vehicle{
    public CargoLorry() {
        super();
    }

    public CargoLorry(String vehicleNo, String vehicleType, Integer maxWeight, Integer noOfPassengers) {
        super(vehicleNo, vehicleType, maxWeight, noOfPassengers);
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public int park(String vehicleNo, String vehicleType) throws IOException {
        return 0;
    }
}
