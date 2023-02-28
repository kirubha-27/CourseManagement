package com.coursemangement.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Read {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String prompt){
        while(true){
            try {
                System.out.println(prompt);
                String val = scanner.nextLine();
                if(!val.isBlank()){
                    return val;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static int stringToInt(String val) throws NumberFormatException {
        return Integer.parseInt(val);
    }

    public static long stringToLong(String val) throws NumberFormatException{
        return Long.parseLong(val);
    }

    public static String getEmail(String prompt){
        while (true) {
            try {
                String res = input(prompt);
                if (Check.isValidEmail(res)) {
                    return res;
                } else {
                    System.out.println("Please Enter a Valid Email.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getDate(String prompt){
        while(true){
            try{
                String res = input(prompt);
                if(Check.isValidDate(res)){
                    return res;
                }else{
                    System.out.println("Please Enter a valid Date.");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String getPassword(String prompt) {
        while (true) {
            String res = input(prompt);
            if (Check.isStrongPassword(res)) {
                return res;
            } else {
                System.out.println("password is to weak. Password must contain one Special Characters,one Capital " +
                        "letters,and numbers");
            }
        }
    }
}
