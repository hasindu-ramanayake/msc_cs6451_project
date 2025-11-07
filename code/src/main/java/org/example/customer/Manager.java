package org.example.customer;

import java.util.Date;

public class Manager extends Staff{

    public Manager(String email, Date joinedDate, int phoneNumber, UserT userType, String staffId, String fullName, boolean adminPrivilege, StaffT staffType) {
        super(email, joinedDate, phoneNumber, userType, staffId, fullName, adminPrivilege, staffType);
    }

    public void addStaff(){}

    public void removeStaff(){}
}
