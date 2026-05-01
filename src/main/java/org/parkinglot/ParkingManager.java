package org.parkinglot;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class ParkingManager {
    private final Semaphore sports;
    private final ParkingDAO dao=new ParkingDAO();
    private final PriorityBlockingQueue<Vehicle> waitingLounge=new PriorityBlockingQueue<>();

    public ParkingManager(int count){

        this.sports = new Semaphore(count,true);
    }

    public int enter(String carNumberPlate,Vehicle vehicle){
       try {
           System.out.println(" " + carNumberPlate + "(" + vehicle.getType() + ") is waiting for a spot...");
           waitingLounge.put(vehicle);

           sports.acquire();
           waitingLounge.remove(vehicle);
           int id=dao.logEntry(carNumberPlate);
           System.out.println(" " + carNumberPlate + " PARKED. (ID: " + id +")");
           return id;
       }catch (InterruptedException e){
           Thread.currentThread().interrupt();
                return -1;
       }

    }

    public void exit(String carNumberPlate,int dbId){
      //  System.out.println("DEBUG: EXIT called for " + carNumberPlate + " with ID" + dbId);
        dao.logExit(dbId,5.00);
        sports.release();
        System.out.println(" " + carNumberPlate + " left. Spot freed");


    }
}
