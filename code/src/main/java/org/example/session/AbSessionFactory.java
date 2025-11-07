package org.example.session;

public abstract class AbSessionFactory {
    abstract public ISessionClass createSession();
    private String generateUniqueId() {
        return "This is Dummy ID";
    }
}

