package org.example.session;

import org.example.core.RandomKeyGenerator;

public abstract class AbSessionFactory {
    public abstract ISessionClass createSession(String userId);
    protected String generateUniqueId() {
        return RandomKeyGenerator.generateRandomKey();
    }
}

