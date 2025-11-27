package org.example.interpreter;

import org.example.cmds.*;

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
            case "vehicle" ->{
                System.out.println("Please Enter Vehicle Details");
                if(!tokenizer.hasMoreTokens()){
                    return cmd;
                }
                //Enter VehicleID
                String vehicleID = tokenizer.nextToken();
                int passangerCount = Integer.parseInt(tokenizer.nextToken());


            }
            case "staff" ->{
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




            }
        };

        return cmd;
    }
    public Command parseRemove(StringTokenizer tokenizer){
        Command cmd = new NoCmd();
        if(!tokenizer.hasMoreTokens()){
            return cmd;
        }
        String remove = tokenizer.nextToken();

        switch(remove){
            case "vehicle"->{
                if(!tokenizer.hasMoreTokens()){
                    return cmd;
                }
                String vehicleID = tokenizer.nextToken();
                cmd = new AdminRemoveVehicle(vehicleID);

            }

        }
        return cmd;
    }



}

