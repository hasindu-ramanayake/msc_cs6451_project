package org.example.core;

public interface ILogger {
    public void setDebug(boolean debug);
    public void normalMessage(String message);
    public void debugMessage(String message);
    public void errorMessage(String message);
}
