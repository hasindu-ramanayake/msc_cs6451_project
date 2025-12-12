package org.example.core;

import org.example.vehicle.VehicleBaseClass;

import java.util.List;

public interface ISingleton {
    default void showMgrName() {
        System.out.println("This is ISingleton");
    }

}
