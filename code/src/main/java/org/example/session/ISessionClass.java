package org.example.session;

public interface ISessionClass {
    public void getUser(); //   this need to be changed to UserClass
    public void setUser(); //   this need to be changed to UserClass
    public String getSessionId();
    public void setSessionId();
    public void updateTimeStamp();
}
