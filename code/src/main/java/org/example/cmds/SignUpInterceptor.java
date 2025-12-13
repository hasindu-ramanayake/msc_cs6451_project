package org.example.cmds;

public class SignUpInterceptor implements CommandInterceptor{
    @Override
    public void preCommand(CommandContext context){
        String emailChecker = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        if( ! context.getContext().matches(emailChecker) ){
            System.out.println("Not a valid email address");
        }
    }
}
