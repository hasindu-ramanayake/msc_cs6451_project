package org.example.customer;

import java.util.Date;

public class UserClass {
    protected String email;
    protected Date joinedDate;
    protected int phoneNumber;
    protected UserT userType;
    protected boolean adminPrivilege;

    public UserClass() {}

    public UserClass(String email, int phoneNumber, UserT userType, boolean adminPrivilege) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.joinedDate = new Date();
        this.adminPrivilege = adminPrivilege;
    }

    public String getEmail() { return email; }
    public int getPhoneNumber() { return phoneNumber; }
    public UserT getUserType() { return userType; }
}
