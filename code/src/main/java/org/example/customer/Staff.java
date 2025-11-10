package org.example.customer;

import java.util.Date;

public class Staff extends UserClass{
    protected String staffId;
    protected String fullName;
    protected boolean adminPrivilege;
    protected StaffT staffType;

    public Staff() {
    }

    public void reportCarState(){}

    public String getStaffId() {
        return "staffId";
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public boolean isAdminPrivilege() {
        return true;
    }

    public void setAdminPrivilege(boolean adminPrivilege) {
        this.adminPrivilege = adminPrivilege;
    }

    public StaffT getStaffType() {
        return StaffT.STAFF;
    }

    public void setStaffType(StaffT staffType) {
        this.staffType = staffType;
    }

    public String getFullName() {
        return "fullName";
    }
}
