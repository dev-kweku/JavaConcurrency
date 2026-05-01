package org.parkinglot;

public class Vehicle extends Thread {
    private final String licensePlate;
    private final ParkingManager manager;

    public Vehicle(String licensePlate,ParkingManager manager){
        this.licensePlate=licensePlate;
        this.manager=manager;
    }

    public void run(){
        int recordId=manager.enter(this.licensePlate);
        try{
            Thread.sleep((long) (Math.random() * 5000));
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        manager.exit(this.licensePlate,recordId);
    }
}
