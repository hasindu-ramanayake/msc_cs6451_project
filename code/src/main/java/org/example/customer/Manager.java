package org.example.customer;

public class Manager extends Staff{

    public Manager(String email, String phoneNumber, String fullName, String staffId, boolean adminPrivilege) {
        super(email, phoneNumber, fullName, StaffT.MANAGER, staffId, adminPrivilege);
    }

    public void addStaff(){}

    public void removeStaff(){}
}