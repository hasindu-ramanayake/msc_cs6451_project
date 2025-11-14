package org.example;

import org.example.cmds.Command;
import org.example.core.CmdParser;
import org.example.core.ISingleton;
import org.example.core.JCRMain;
import org.example.session.SessionClass;
import org.example.session.SessionMgr;

import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Main {
    static void main() {

        ISingleton jcrMgr = JCRMain.getInstance();
        jcrMgr.showMgrName();

        // starting the main terminal:
        Scanner cmdReader = new Scanner(System.in);
        System.out.println("===Welcome to JCR rental services ====\n");
        System.out.println("Use Command login/signin or signout/exit \n\n");

        // set session for the user
        SessionClass userSession = null;

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
