package org.example.customer;

import java.util.Date;

public class Staff extends UserClass{
    protected String staffId;
    protected String fullName;
    protected boolean adminPrivilege;
    protected StaffT staffType;

    public Staff(String email, Date joinedDate, int phoneNumber, UserT userType, String staffId, String fullName, boolean adminPrivilege, StaffT staffType) {
        super(email, joinedDate, phoneNumber, userType);
        this.staffId = staffId;
        this.fullName = fullName;
        this.adminPrivilege = adminPrivilege;
        this.staffType = staffType;
    }

    public void reportCarState(){}

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public boolean isAdminPrivilege() {
        return adminPrivilege;
    }

    public void setAdminPrivilege(boolean adminPrivilege) {
        this.adminPrivilege = adminPrivilege;
    }

    public StaffT getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffT staffType) {
        this.staffType = staffType;
    }

    public String getFullName() {
        return fullName;
    }
}
