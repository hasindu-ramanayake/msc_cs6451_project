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

    public String getUser() {return this.user; }
    public String getSessionId() { return this.sessionId;}
    public LocalDateTime getLastTimeStamp( ) { return this.timeStamp;}
    public void updateTimeStamp() {
        this.timeStamp = LocalDateTime.now();
    }
    public boolean isExpired() {
        return (ChronoUnit.MINUTES.between(this.getLastTimeStamp(), LocalDateTime.now()) <= 5 );
    }
}
