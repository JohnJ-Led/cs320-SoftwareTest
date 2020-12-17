package com.grandstrandsystems.demo;

/**
 * Appointment Class
 * 
 * @author john.ledbetter@snhu.edu
 */

public class Appointment {
    String appointmentId;
    String thisDate;
    String description;
    Validate testValidate = new Validate();
    /**
     * Default Constructor 
     * Set to private to prevent empty instances.
     */
    private Appointment(){

    }

    /**
     * Constructor with initialization parameters.
     * @param appointmentId
     * @param date
     * @param description
     */
    public Appointment(String appointmentId, String date, String description){
        this();
        if(testValidate.validate(appointmentId, 10, "id")){
            this.appointmentId = appointmentId;
        }
        if(testValidate.validate(date, 10, "date")){
            this.thisDate = date;
        }
        if(testValidate.validate(description, 50, "description")){
            this.description = description;
        }
    }

    /**
     * AppointmentId Accessor
     * @return AppointmentId
     */
    public String getAppointmentId(){
        return appointmentId;
    }

    /**
     * Fistdate Accessor
     * @return firstdate
     */
    public String getDate(){
        return thisDate;
    }
    /**
     * Lastdate Accessor
     * @return lastdate
     */
    public String getDescription(){
        return description;
    }
}
