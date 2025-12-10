////No need for two dispatchers
//
//package org.example.cmds;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmailDispatcher {
//    private final List<IEmailCommandInterceptor> interceptors;
//
//    public EmailDispatcher(){
//        this.interceptors = new ArrayList<>();
//    }
//
//    public void registerInterceptor(IEmailCommandInterceptor interceptor){
//        interceptors.add(interceptor);
//    }
//    public void processCommand(EmailCommandContext context) {
//        for (IEmailCommandInterceptor interceptor : interceptors) {
//            interceptor.preCommand(context);
//        }
//
//        for (IEmailCommandInterceptor interceptor : interceptors) {
//            interceptor.postCommand(context);
//        }
//    }
//}
