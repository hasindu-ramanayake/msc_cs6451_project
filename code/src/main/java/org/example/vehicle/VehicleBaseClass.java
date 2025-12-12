package org.example.vehicle;

public class VehicleBaseClass {
    protected String vehicleID;
    private IVehicleGrade vehicleGrade;
    private VehicleStateT vehicleState;
    private int passengerCount;
    private MakeT make;
    private ModelT model;
    private VehicleColorT color;


    public VehicleBaseClass(){

    }

    public VehicleBaseClass(String vehicleID, IVehicleGrade vehicleGrade, VehicleStateT vehicleState, int passengerCount, MakeT make, ModelT model, VehicleColorT color) {
        this.vehicleID = vehicleID;
        this.vehicleGrade = vehicleGrade;
        this.vehicleState = vehicleState;
        this.passengerCount = passengerCount;
        this.make = make;
        this.model = model;
        this.color = color;

    }

    public String getVehicleID()
    {
        return vehicleID;
    }

    public IVehicleGrade getVehicleGrade()
    {
        return vehicleGrade;
    }

    public void setVehicleGrade(IVehicleGrade vehicleGrade)
    {
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


    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return "VehicleBaseClass {" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleGrade=" + vehicleGrade +
                ", vehicleState=" + vehicleState +
                ", passengerCount=" + passengerCount +
                ", make=" + make +
                ", model=" + model +
                ", color=" + color +
                '}';
    }
}
