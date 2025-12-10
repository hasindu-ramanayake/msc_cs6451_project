package org.example.core;

public class LoggerFactory extends AbLoggerFactory{

    public ILogger createLogger(){
        return new Logger();
    }
}
