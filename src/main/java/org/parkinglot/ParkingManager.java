package org.parkinglot;

import java.util.concurrent.Semaphore;

public class ParkingManager {
    private final Semaphore sports;

    public ParkingManager(int totalSpots, Semaphore sports){

        this.sports = new Semaphore(totalSpots,true);
    }

    public void enter(String carNumberPlate){
        try{
            System.out.println(" " + carNumberPlate + " is looking for a spot...");
            sports.acquire();
            System.out.println(" " + carNumberPlate + " has PARKED, Sports left : " + sports.availablePermits());

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void exit(String carNumberPlate){
        System.out.println(" " + carNumberPlate + " is leaving");
        sports.release();
        System.out.println("Spot freed by " + carNumberPlate + " .Total available: "+ sports.availablePermits());
    }
}
