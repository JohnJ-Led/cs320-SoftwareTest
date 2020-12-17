package com.grandstrandsystems.demo;
/**
 * Appointment Service Class
 * 
 * @author john.ledbetter@snhu.edu
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class AppointmentService{

//Initiate List and Service
private static List<Appointment> appointments = new ArrayList<Appointment>();
private static AppointmentService instance = new AppointmentService();
String theAppointmentId;


/**
 * Get the instance of the Appointment service
 * 
 * @return instance
 */
public static AppointmentService getService(){
    return instance;
}

//Need to create multiple new Appointments with unique ID
/**
 * Adds a Appointment if one does not exist for ID generated, returns Appointment if ID exist already
 * @param theName
 * @param theDescription
 * @return
 */
public Appointment addAppointment(String date, String theDescription){
    //Local instance of Appointment
    Appointment appointment = null;
    String appointmentSeed = "App";
    int appointmentIncrement;
    String lastAppMade;
    int lastAppPosition;
    //Create Unique ID. Assumption is that no duplicate Appointment will be made. 
    //If two Appointment have the same name and descritpion they are seperate objects.
    //Uniqueness should be optained by only allowing the generation of an appointment number larger than the last entry. 
    //Appointments are only inserted at the end of the list. Deleted apps in the middle of the list will not have re-useable IDs.
    if(appointments.size() == 0){
        theAppointmentId = appointmentSeed+ "1";

    }
    else{
        lastAppMade = appointments.get(appointments.size()-1).appointmentId;
        appointmentIncrement = appointments.size() + 1;
        if(appointmentIncrement > 9999999){
            throw new IndexOutOfBoundsException("MAX Number of Appointment reached");
        }
        lastAppPosition = Integer.parseInt(String.valueOf(lastAppMade.substring(3)));
        if(lastAppPosition >= appointmentIncrement){
            appointmentIncrement = lastAppPosition+1;
        }
        theAppointmentId = appointmentSeed + Integer.toString(appointmentIncrement);
    }

    //Add if doesn't exist
    if(appointment == null){
        appointment = new Appointment(theAppointmentId, date, theDescription);
        appointments.add(appointment);
    }

    return appointment;
}

/**
 * Removes Appointment from the Appointments instance
 * @param cId
 */
public void removeAppointment(String cId){
    Appointment appointment = getAppointment(cId);
    appointments.remove(appointment);
}

/**
 * Returns the Appointment instance at the index
 * @param index
 * @return Appointment instance at index
 */
public Appointment getAppointment(int index){
    return appointments.get(index);
}

/**
 * Returns the Appointment instance based on AppointmentId
 * @param cId
 * @return Appointment
 */
public Appointment getAppointment(String cId){

    Appointment Appointment = null;
    int i = 0;

        //return the instance of Appointment
        Iterator<Appointment> hasInstance = appointments.iterator();
        //Loop through instance and return Appointment
        while(hasInstance.hasNext()){
            String tempId = hasInstance.next().getAppointmentId();
            if(cId.equals(tempId)){
                Appointment = getAppointment(i);
            }
            i++;
        }

        if(Appointment == null){
            throw new IllegalArgumentException(String.format("Appointment '%s' Not Found", cId));
        }
    return Appointment;
}

}
