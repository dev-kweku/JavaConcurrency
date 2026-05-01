package org.parkinglot;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ParkingManager manager=new ParkingManager(5);
//        List<Vehicle> cars=new ArrayList<>();

        ParkingManager manager=new ParkingManager(1);

        new Vehicle("REG-1",VehicleType.REGULAR,manager).start();

        new Vehicle("REG-2",VehicleType.REGULAR,manager).start();
        new Vehicle("AMBULANCE-911",VehicleType.EMERGENCY,manager).start();


//        for(int i=1;i<=10;i++){
//            Vehicle car=new Vehicle("GT-" + i + "-26",manager);
//            cars.add(car);
//            car.start();
//
////            try{
////                Thread.sleep(500);
////            }catch(InterruptedException e){
////                e.printStackTrace();
////            }
//        }
//
//        for(Vehicle car:cars){
//            try{
//                car.join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//        System.out.println("All cars have left,Shutting down system");


    }
}