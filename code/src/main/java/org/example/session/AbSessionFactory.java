package org.example.session;

public abstract class AbSessionFactory {
    abstract public ISessionClass createSession(String userId);
    protected String generateUniqueId() {
        return "AISDKDAIdbaksjdbaliiBD";
    }
}

