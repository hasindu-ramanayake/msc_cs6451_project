package org.example.session;

import java.time.LocalDateTime;

public class SessionClass implements ISessionClass{

    private int user;   // this need to be user class
    private String sessionId;
    private LocalDateTime createTime;
    private LocalDateTime timeStamp;

    public SessionClass() {
        System.out.println("DEBUG: SESSION CREATED..");
    }

    public void getUser() {} //   this need to be changed to UserClass
    public void setUser() {} //   this need to be changed to UserClass
    public String getSessionId() { return "SetDUMMYId";}
    public void setSessionId() {}
    public void updateTimeStamp() {}
}
