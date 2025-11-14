package org.example.session;

import java.time.LocalDateTime;

public interface ISessionClass {
    public String getUser(); //   this need to be changed to UserClass
    public void setUser(); //   this need to be changed to UserClass
    public String getSessionId();
    public void setSessionId();
    public void updateTimeStamp();
    public boolean validateSession();
}
