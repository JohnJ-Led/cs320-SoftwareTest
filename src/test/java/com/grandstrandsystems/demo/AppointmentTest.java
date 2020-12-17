package com.grandstrandsystems.demo;

/**
 * Appointment Class Test
 * Author john.ledbetter@snhu.edu
 * 
 * Description: This class is for testing methods developed in the Appointment.java class
 * 
 * Notes: 
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppointmentTest {
    @BeforeAll
    static void setupAll(){
        System.out.println("Start test failures");
    }


    @BeforeEach
    void setupEach(){
        System.out.println("Start each test failures");
    }

    @Test
    @DisplayName("Your Appointment Info is to Long (╯°□°）╯︵ ┻━┻")
    void testAppointmentClassToLong(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Appointment("App1","12-25-2020","ThisisdescThisisdescThisisdescThisisdescThisisdesc1"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Appointment("App2","12-25-20201","ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Appointment("Appointment","12-25-2020","ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        
    }
    
    @Test
    @DisplayName("Your Appointment Info is Null (╯°□°）╯︵ ┻━┻")
    void testAppointmentClassNull(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Appointment(null,"12-25-2020","ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Appointment("App2",null,"ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Appointment("App3","12-25-2020",null));
    }

    @Test
    @DisplayName("Your Appointment Info is Good... ┬─┬ ノ( ゜-゜ノ)")
    void testAppointmentClass(){
        Appointment newAppointment = new Appointment("App1","12-25-2020","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
        assertAll("New Appointment", () -> assertEquals("App1", newAppointment.getAppointmentId()), () -> assertEquals("12-25-2020", newAppointment.getDate()),() -> assertEquals("ThisisdescThisisdescThisisdescThisisdescThisisdesc", newAppointment.getDescription()));
    }

    @AfterAll
    @DisplayName("I broke them")
    static void teardownAll(){
        System.out.println("I finished breaking them");
    }

}
