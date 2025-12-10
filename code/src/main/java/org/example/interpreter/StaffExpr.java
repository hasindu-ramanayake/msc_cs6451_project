package org.example.interpreter;

import org.example.cmds.*;
import org.example.vehicle.VehicleStateT;

import java.util.StringTokenizer;

public class StaffExpr implements  Expression {
    @Override
    public Command interpret(String input){
        StringTokenizer inputTokens = new StringTokenizer(input);

        Command cmd = new NoCmd();

        inputTokens.nextToken(); // skip staff token
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();

        // processing the second word
        String action = inputTokens.nextToken();

        if ( !action.matches("report") ) return new NoCmd();
        if (!inputTokens.hasMoreTokens()){
            return new NoCmd();
        }
        String vehicleId = inputTokens.nextToken();
        if (!inputTokens.hasMoreTokens()){
            return new NoCmd();
        }
        String vehicleState = inputTokens.nextToken();
        switch(vehicleState){
            case "checkin" ->{
                cmd = new StaffReportCheckIn(vehicleId, VehicleStateT.CHECK_IN);
            }
            case "checkout" ->{
                cmd = new StaffReportCheckOut(vehicleId, VehicleStateT.CHECK_OUT);
            }
            case "outoforder" ->{
                cmd = new StaffReportOutOfOrder(vehicleId, VehicleStateT.OUT_OF_ORDER);
            }
            case "ready" ->{
                cmd = new StaffReportReady(vehicleId, VehicleStateT.READY);
            }
            default ->{
                return new NoCmd();
            }

        }
        return cmd;
    }

}
