package org.example.customer;

import java.util.Date;

public class Manager extends Staff{

    public Manager(String email, int phoneNumber, String fullName, String staffId, boolean adminPrivilege) {
        super(email, phoneNumber, fullName, StaffT.MANAGER, staffId, adminPrivilege);
    }

    public void addStaff(){}

    public void removeStaff(){}
}
