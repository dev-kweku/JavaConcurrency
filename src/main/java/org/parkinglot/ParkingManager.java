package org.parkinglot;

import java.util.concurrent.Semaphore;

public class ParkingManager {
    private final Semaphore sports;
    private final ParkingDAO dao=new ParkingDAO();

    public ParkingManager(int count){

        this.sports = new Semaphore(count,true);
    }

    public int enter(String carNumberPlate){
        try{
            sports.acquire();
            return dao.logEntry(carNumberPlate);

        }catch (InterruptedException e){
            return -1;
        }

    }

    public void exit(String carNumberPlate,int dbId){
        System.out.println("DEBUG: EXIT called for " + carNumberPlate + " with ID" + dbId);
        dao.logExit(dbId,5.00);
        sports.release();


    }
}
