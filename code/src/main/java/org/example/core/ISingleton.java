package org.example.core;

public interface ISingleton {
    default void showMgrName() {
        System.out.println("This is ISingleton");
    }
}
