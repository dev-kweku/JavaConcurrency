package org.parkinglot;


public class Main {
    public static void main(String[] args) {
        ParkingManager manager=new ParkingManager(5);

        for(int i=1;i<=10;i++){
            Vehicle car=new Vehicle("GT-" + i + "-26",manager);
            car.run();


            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}