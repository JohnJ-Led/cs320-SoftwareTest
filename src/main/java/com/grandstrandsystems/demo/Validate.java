package com.grandstrandsystems.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {

    private boolean pass = false;
    private SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * Default Constructor 
     * Set to private to prevent empty instances.
     */
    public Validate(){}

    /**
     * Pass parameters into function to test if the meet requirements.
     * Will test for: 
     * *Null
     * *A max length of item or min lenght if phone number
     * *A Valid date format and greater than equal to current day.
     * 
     * @param myTest
     * @param myMax
     * @param myType
     * @return
     */
    public boolean validate(String myTest,int myMax, String myType){

        try{
            if(myTest == null || myTest.length() > myMax){
                throw new IllegalArgumentException("Invalid " + myType);
            }
            if(myType.equals("phone number")){
                for(int i = 0; i < myTest.length(); i++){
                    if(!Character.isDigit(myTest.charAt(i))){
                        throw new IllegalArgumentException("Invalid " + myType);
                    }
                }
                if(myTest.length() < 10){
                    throw new IllegalArgumentException("Invalid " + myType);
                }
                pass = true;
            }
            if(myType.equals("date")){
                try{
                    //When you're stupid and you know it clap your hands. *clap clap* Creating date obejects add MM:SS:SSS TZ
                    //Below Sets "today" as zero hour. To properly compare dates.
                    Date today = formatter.parse(formatter.format(new Date()));
                    System.out.println("Start");
                    Date myDate = formatter.parse(myTest);
                    
                    if(myDate.before(today)){
                        throw new IllegalArgumentException("Date in past or null. Enter new date.: ");
                    }
                }
                catch (ParseException e){
                    throw new IllegalArgumentException("Incorrect Format");
                }
                finally{

                }
                
            }
            System.out.println("Did I get");
            pass = true;
        }
        finally{
            System.out.println("Try Statements Ran for " + myType);
        }

        return pass;
    }    
}
