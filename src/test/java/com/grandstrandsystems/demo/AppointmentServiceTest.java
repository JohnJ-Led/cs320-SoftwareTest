package com.grandstrandsystems.demo;

/**
 * Appointment Service Test Class
 * 
 * @author john.ledbetter@snhu.edu
 * 
 * Description: This class is for testing methods developed in the AppointmentService.java class
 * 
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceTest {

    private AppointmentService testInstancService = new AppointmentService();
    private Appointment expectedAppointment1; // = new Appointment("App1","12-25-2020","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
    private Appointment expectedAppointment2; // = new Appointment("App2","01-01-2021","WhatisdescWhatisdescWhatisdescWhatisdescWhatisdesc");
    private Appointment expectedAppointment3; // = new Appointment("App3","05-01-2021","WhomisdescWhomisdescWhomisdescWhomisdescWhomisdesc");
    private Appointment actualAppointment;
    
    @BeforeAll
    static void setUpAll(){
        System.out.println("Lets begin the test");
    }
    @AfterAll
    static void tearItAll(){
        System.out.println("If we get here...we have succeed in at least getting here.");
    }



    @Nested
    class testAppointmentAddMethod{

        @BeforeEach
        void setUpAddAppointment(){
            System.out.println("Lets add a Appointment");
            expectedAppointment1 = new Appointment("App1","11-27-2021","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
        }
        @AfterEach
        void tearDownAddAppointment(){
            System.out.println("We added a Appointment.");
            expectedAppointment1 = null;
        }
        @Test
        @DisplayName("Add: Test to add a Appointment")
        public void testAddAppointment(){
            actualAppointment = testInstancService.addAppointment("10-20-2021","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
            assertAll("Add Appointment", () -> assertEquals("App1", actualAppointment.appointmentId), () -> assertEquals("10-20-2021", actualAppointment.thisDate), () -> assertEquals("ThisisdescThisisdescThisisdescThisisdescThisisdesc", actualAppointment.description));
            System.out.println(actualAppointment.appointmentId);
        }
        
        @Nested
        class testMultipleAppointments{
            @BeforeEach
            void setUpAddAppointment(){
                System.out.println("Lets add a Appointment");
                expectedAppointment3 = new Appointment("App3","11-27-2021","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
                for(int i = 0; i < 4; i++){
                testInstancService.addAppointment("11-27-2021","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
                }
            }
            @Test
            @DisplayName("Remove appointment and Increment to Next Appointment")
            void  removeAppointmentAddAppointment(){
                testInstancService.removeAppointment(expectedAppointment3.appointmentId);
                actualAppointment = testInstancService.addAppointment("11-27-2021","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
                assertAll("Add Appointment", () -> assertEquals("App5", actualAppointment.appointmentId), () -> assertEquals("11-27-2021", actualAppointment.thisDate), () -> assertEquals("ThisisdescThisisdescThisisdescThisisdescThisisdesc", actualAppointment.description));

            }

            @AfterEach
            void tearDownAddAppointment(){
                System.out.println("We added a Appointment.");
                expectedAppointment3 = null;
                actualAppointment = null;
            }
        }
        
        @Nested
        class testAppointmentGetMethod{
            @BeforeEach
            void setUpGetAppointment(){
                System.out.println("Lets get a Appointment");
                //expectedAppointment1 = new Appointment("Appointment1","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
                expectedAppointment3 = new Appointment("App3","05-01-2021","WhomisdescWhomisdescWhomisdescWhomisdescWhomisdesc");
            }
            @AfterEach
            void tearDownGetAppointment(){
                System.out.println("We got the Appointment.");
                expectedAppointment1 = null;
            }
            
            @Test
            @DisplayName("Get: Test to get a Appointment")
            void testGetAppointment(){
                System.out.println(expectedAppointment1.appointmentId);
                assertNotNull(testInstancService.getAppointment(expectedAppointment1.appointmentId));
            }
            
            @Test
            @DisplayName("Get: Request a Appointment that does not exist")
            void testGetAppointmentException(){
                Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.getAppointment(expectedAppointment3.appointmentId));
            }
            @Nested
            class testAppointmentRemoveMethod{
                @BeforeEach
                void setUpGetAppointment(){
                    System.out.println("BeforeEach: Lets remove Appointment");
                    expectedAppointment2 = new Appointment("App2","01-01-2021","WhatisdescWhatisdescWhatisdescWhatisdescWhatisdesc");
                }
                @AfterEach
                void tearDownGetAppointment(){
                    System.out.println("AfterEach: We removed the Appointment.");
                    expectedAppointment1 = null;
                    expectedAppointment2 = null;
                }
                @Test
                @DisplayName("Remove: Test remove a Appointment that exist")
                void testRemoveAppointment(){
                    String thisIDInstance = expectedAppointment1.appointmentId;
                    System.out.println(thisIDInstance);
                    testInstancService.removeAppointment(expectedAppointment1.appointmentId);
                    Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.removeAppointment(expectedAppointment1.appointmentId));

                }

                @Test
                @DisplayName("Remove: Remove a Appointment that DNE")
                void testRemoveAppointmentException(){
                   Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.removeAppointment(expectedAppointment2.appointmentId));
                    
                }
            }
        }
        
    }

}
