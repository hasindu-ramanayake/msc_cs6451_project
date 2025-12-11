package org.example.interpreter;

import org.example.cmds.*;
import org.example.vehicle.*;

import java.util.StringTokenizer;

public class AdminExp implements Expression{
    @Override
    public Command interpret(String input){
        //New String
        StringTokenizer inputTokens = new StringTokenizer(input);

        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();
        inputTokens.nextToken();
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();

        String action = inputTokens.nextToken();

        return switch(action){
            case "add" -> parseAdd(inputTokens);
            case "remove" -> parseRemove(inputTokens);

            default -> new NoCmd();

        };

    }
    public Command parseAdd(StringTokenizer tokenizer){
        Command cmd = new NoCmd();
        if(!tokenizer.hasMoreTokens()){
            return new NoCmd();
        }
        String add = tokenizer.nextToken();

        switch(add){
            case "vehicle" :{
                System.out.println("Please Enter Vehicle Details in the Format ");
                if(!tokenizer.hasMoreTokens()){
                    return cmd;
                }
                //Enter VehicleID and Details
                String vehicleID = tokenizer.nextToken();
                VehicleGradeT vehicleGrade = VehicleGradeT.getType(tokenizer.nextToken());
                int passengerCount = Integer.parseInt(tokenizer.nextToken());
                ModelT model = ModelT.getType(tokenizer.nextToken());
                MakeT make = MakeT.getType(tokenizer.nextToken());
                VehicleColorT color = VehicleColorT.getType(tokenizer.nextToken());

                cmd = new AdminAddVehicle(vehicleID, VehicleGradeT.createInterface(vehicleGrade), passengerCount, make, model, color);
                break;
            }
            case "staff" :{
                System.out.println("Please Enter Staff Details");
                if(!tokenizer.hasMoreTokens()){
                    return cmd;
                }
                //Enter Email
                String email = tokenizer.nextToken();
                if(!tokenizer.hasMoreTokens()){return cmd;}
                //Enter Phone Number
                int phoneNumber = Integer.parseInt(tokenizer.nextToken());
                if(!tokenizer.hasMoreTokens()){return cmd;}
                String fullname = tokenizer.nextToken();
                if(!tokenizer.hasMoreTokens()){return cmd;}
                String staffID = tokenizer.nextToken();
                break;
            }
            default : assert(true);
        }

        return cmd;
    }
    public Command parseRemove(StringTokenizer tokenizer){
        Command cmd = new NoCmd();
        if(!tokenizer.hasMoreTokens()){
            return cmd;
        }
        String remove = tokenizer.nextToken();

        switch(remove){
            case "vehicle" : {
                if(!tokenizer.hasMoreTokens()){
                    return cmd;
                }
                String vehicleID = tokenizer.nextToken();
                cmd = new AdminRemoveVehicle(vehicleID);
                break;
            }
            default : {
                return new NoCmd();
            }

        }
        return cmd;
    }



}

