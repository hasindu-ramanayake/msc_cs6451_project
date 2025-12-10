package org.example.cmds;

public class EmailCommandContext implements ICommandContext{
    private String email;

    public EmailCommandContext(String email){
        this.email = email;
    }
    @Override
    public String getContext(){
        return email;
    }
    @Override
    public void setContext(String email){
        this.email = email;
    }
}
