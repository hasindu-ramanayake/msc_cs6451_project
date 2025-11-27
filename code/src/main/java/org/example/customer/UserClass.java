package org.example.customer;

import java.util.Date;

public class UserClass {
    protected String email;
    protected Date joinedDate;
    protected String phoneNumber;
    protected UserT userType;
    protected boolean adminPrivilege;

    public UserClass() {}

    public UserClass(String email, String phoneNumber, UserT userType) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.joinedDate = new Date();
    }

    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public UserT getUserType() { return userType; }
}
