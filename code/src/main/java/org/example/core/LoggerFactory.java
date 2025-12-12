package org.example.core;

public class LoggerFactory extends AbLoggerFactory implements ISingleton{
    public ILogger createLogger(){
        return new Logger();
    }

}
