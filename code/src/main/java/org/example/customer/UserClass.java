package org.example.customer;

import java.util.Date;

public class UserClass {
    protected String email;
    protected Date joinedDate;
    protected int phoneNumber;
    protected UserT userType;

    public UserClass(String email, Date joinedDate, int phoneNumber, UserT userType) {
        this.email = email;
        this.joinedDate = joinedDate;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }
}
