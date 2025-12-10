package org.example.session;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.LoggerFactory;

import java.time.LocalDateTime;


public class SessionClass implements ISessionClass{

    private final String user;   // this need to be user class
    private final String sessionId;
    private LocalDateTime timeStamp;
    private final ILogger logger;

    public SessionClass(String userId, String sessionId) {
        this.user = userId;
        this.sessionId = sessionId;
        this.timeStamp = LocalDateTime.now();
        AbLoggerFactory log = new LoggerFactory();
        this.logger = log.createLogger();
        logger.debugMessage("Session created for user: " + this.user);
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
