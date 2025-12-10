package org.example.session;

import java.time.LocalDateTime;

public interface ISessionClass {
    public String getUser();
    public String getSessionId();
    public void updateTimeStamp();
    public LocalDateTime getLastTimeStamp();
    public boolean isExpired();
}
