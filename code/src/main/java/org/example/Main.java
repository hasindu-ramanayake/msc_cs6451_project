package org.example;

import org.example.core.ISingleton;
import org.example.core.JCRMain;
import org.example.session.SessionMgr;

public class Main {
    static void main() {

        ISingleton jcrMgr = JCRMain.getInstance();
        jcrMgr.showMgrName();


    }
}

// manually run the file
// > mvn clean install
// > java -jar target/code-1.0-SNAPSHOT.jar
