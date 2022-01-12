package model;

import java.io.IOException;

public class Van extends Vehicle{
    int[] vanSlots = new int[]{1,2,3,4,12,13};

    public Van() {
        super();
    }

    public Van(String vehicleNo, String vehicleType, Integer maxWeight, Integer noOfPassengers) {
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
