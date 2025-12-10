package org.example.cmds;

public class CommandContext {
    private String data;

    public CommandContext(String data) {
        this.data = data;
    }

    public String getContext() {
        return data;
    }

    public void setContext(String data) {
        this.data = data;
    }
}
