package org.example;

import org.example.cmds.Command;
import org.example.interpreter.CmdParser;
import org.example.core.ISingleton;
import org.example.core.JCRMain;


import org.example.session.SessionWrapper;

import java.util.Scanner;

public class Main {
    static void main() {

        ISingleton jcrMgr = JCRMain.getInstance();
        jcrMgr.showMgrName();

        // starting the main terminal:
        Scanner cmdReader = new Scanner(System.in);
        System.out.println("===Welcome to JCR rental services ====\n");
        System.out.println("Use Command help to access any further information. \n\n");

        // set session for the user
        SessionWrapper userSession = new SessionWrapper();

        while (true) {
            System.out.print("[JCR] > ");
            String input = cmdReader.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using JRC. Goodbye!\n");
                break;
            }

            // call the cmd parser and execute the cmd
            Command cmd = CmdParser.parse(input);
            cmd.execute(userSession);
        }
        cmdReader.close();



    }
}

// manually run the file
// > mvn clean install
// > java -jar target/code-1.0-SNAPSHOT.jar
