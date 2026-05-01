package org.parkinglot;

public enum VehicleType {
    EMERGENCY(1),VIP(2),REGULAR(3);

    final int priorityLevel;
    VehicleType(int priorityLevel){
        this.priorityLevel=priorityLevel;
    }
}
