package org.example.customer;

public class Staff extends UserClass{
    protected String staffId;
    protected String fullName;
    protected boolean adminPrivilege;
    protected StaffT staffType;

    public Staff(String email, String phoneNumber, String fullName, StaffT staffType, String staffId, boolean adminPrivilege) {
        super(email, phoneNumber, UserT.STAFF);
        this.staffId = staffId;
        this.fullName = fullName;
        this.staffType = staffType;
        this.adminPrivilege = adminPrivilege;
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
