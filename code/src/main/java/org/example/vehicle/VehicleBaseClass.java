package org.example.vehicle;

public class VehicleBaseClass {
    private String vehicleID;
    private IVehicleGrade vehicleGrade;
    private VehicleStateT vehicleState;
    private int passengerCount;
    private MakeT make;
    private ModelT model;
    private VehicleColorT color;
    private AbRentalRateBaseClass rentalRate;

    public VehicleBaseClass() {
    }

    public IVehicleGrade getVehicleGrade() {
        return vehicleGrade;
    }

    public void setVehicleGrade(IVehicleGrade vehicleGrade) {
        this.vehicleGrade = vehicleGrade;
    }

    public VehicleStateT getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleStateT vehicleState) {
        this.vehicleState = vehicleState;
    }

    public MakeT getMake() {
        return make;
    }

    public void setMake(MakeT make) {
        this.make = make;
    }

    public ModelT getModel() {
        return model;
    }

    public void setModel(ModelT model) {
        this.model = model;
    }

    public VehicleColorT getColor() {
        return color;
    }

    public void setColor(VehicleColorT color) {
        this.color = color;
    }

    public AbRentalRateBaseClass getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(AbRentalRateBaseClass rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getVehicleID() {
        return vehicleID;
    }
}
