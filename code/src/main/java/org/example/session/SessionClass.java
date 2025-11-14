package org.example.session;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SessionClass implements ISessionClass{

    private final String user;   // this need to be user class
    private final String sessionId;
    private LocalDateTime timeStamp;

    public SessionClass(String userId, String sessionId) {
        this.user = userId;
        // TODO: need to check in the database for userID
        this.sessionId = sessionId;
        this.timeStamp = LocalDateTime.now();
        System.out.println("DEBUG: Session created for user: " + this.user);
    }

    public String getUser() {return this.user; } //   this need to be changed to UserClass
    public void setUser() {} //   this need to be changed to UserClass
    public String getSessionId() { return this.sessionId;}
    public void setSessionId() {}
    public boolean validateSession() {
        return ChronoUnit.MINUTES.between(timeStamp, LocalDateTime.now()) <= 5;
    }
    public void updateTimeStamp() {
        this.timeStamp = LocalDateTime.now();
    }
}
