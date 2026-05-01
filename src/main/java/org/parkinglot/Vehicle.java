package org.parkinglot;

public class Vehicle extends Thread implements Comparable<Vehicle> {
    private final String licensePlate;
    private final ParkingManager manager;
    private final VehicleType type;

    public Vehicle(String licensePlate,VehicleType type,ParkingManager manager){
        this.licensePlate=licensePlate;
        this.type=type;
        this.manager=manager;

    }

    public VehicleType getType(){
        return this.type;
    }

    public int compareTo(Vehicle other){
        return Integer.compare(this.type.priorityLevel,other.type.priorityLevel);
    }

    public void run(){
        int recordId=manager.enter(this.licensePlate,this);
        try{
            Thread.sleep((long) (Math.random() * 5000));
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        manager.exit(this.licensePlate,recordId);
    }
}
