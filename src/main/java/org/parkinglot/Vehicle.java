package org.parkinglot;

public class Vehicle {
    private final String licensePlate;
    private final ParkingManager manager;

    public Vehicle(String licensePlate,ParkingManager manager){
        this.licensePlate=licensePlate;
        this.manager=manager;
    }

    public void run(){
        manager.enter(licensePlate);
        try{
            Thread.sleep((long) Math.random() * 5000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        manager.exit(licensePlate);
    }
}
