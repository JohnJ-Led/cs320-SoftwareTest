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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidatieTest {
    
    Validate myInstance = new Validate();
    private SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

    @BeforeAll
    static void setUp(){
        System.out.println("Starting this.");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("Finished this.");
    }

    @Test
    @DisplayName("Length Boundary Test")
    void testValidateMaxLength(){
        Assertions.assertTrue(()-> myInstance.validate("SomeTest", 8 , "aType1"));
        Assertions.assertTrue(()-> myInstance.validate("SomeTest", 10 , "aType2"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> myInstance.validate("SomeTest", 7 , "aType3"));
    }
    @Test
    @DisplayName("Test Valid Phone Number Format")
    void testValidatePhoneNumber(){
        Assertions.assertTrue(()-> myInstance.validate("1234567890", 10 , "phone number"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> myInstance.validate("123456", 10 , "phone number"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> myInstance.validate("S234567890", 10 , "phone number"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> myInstance.validate("123456789F", 10 , "phone number"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> myInstance.validate("1234t67890", 10 , "phone number"));
    }
    @Test
    @DisplayName("Test Valid Date Format")
    void testValidateDate(){
       Assertions.assertTrue(()-> myInstance.validate("12-27-2020", 10 , "date"));
       Assertions.assertThrows(IllegalArgumentException.class,()-> myInstance.validate("Jun-2020", 10 , "date"));
       Assertions.assertTrue(()-> myInstance.validate(formatter.format(new Date()), 10 , "date"));
       Assertions.assertThrows(IllegalArgumentException.class, ()-> myInstance.validate("11-22-2020", 10 , "date"));
       //Assertions.assertTrue(()-> myInstance.validate("11-26-2020", 10 , "date"));
    }

}
