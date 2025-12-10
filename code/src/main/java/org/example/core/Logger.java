package org.example.core;

public class Logger implements ILogger{
    private boolean debug;

    public Logger(){
        this.debug = false;
    }

    @Override
    public void setDebug(boolean debug){
        this.debug = debug;
    }

    @Override
    public void debugMessage(String message){
        if(debug) System.out.println("DEBUG: "+message);
    }

    @Override
    public void errorMessage(String message){
        if(debug) System.out.println("ERROR: "+message);
    }


}
