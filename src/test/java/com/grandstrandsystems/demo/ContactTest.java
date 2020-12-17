/**
 * Contact Class Test
 * Author john.ledbetter@snhu.edu
 * 
 * Description: This class is for testing methods developed in the Contact.java class
 * 
 * Notes: 
 */


package com.grandstrandsystems.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContactTest {
    
    @BeforeAll
    static void setupAll(){
        System.out.println("Start test failures");
    }


    @BeforeEach
    void setupEach(){
        System.out.println("Start each test failures");
    }

    @Test
    @DisplayName("Your Contact Info is to Long (╯°□°）╯︵ ┻━┻")
    void testContactClassToLong(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed12349","Jacob","Ledbetter","1234567890","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","JacobJacobJ","Ledbetter","1234567890","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","Jacob","Ledbetterrr","1234567890","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","Jacob","Ledbetter","12345678900","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","Jacob","Ledbetter","1234567890","ThisaplaceThisaplaceThisaplace1"));
    }
    
    @Test
    @DisplayName("Your Contact Info is Null (╯°□°）╯︵ ┻━┻")
    void testContactClassNull(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact(null,"Jacob","Ledbetter","1234567890","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234",null,"Ledbetter","1234567890","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","Jacob",null,"1234567890","Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","Jacob","Ledbetter",null,"Thisaplace"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Contact("JacLed1234","Jacob","Ledbetter","1234567890", null));
    }

    @Test
    @DisplayName("Your Contact Info is Good... ┬─┬ ノ( ゜-゜ノ)")
    void testContactClass(){
        Contact newContact = new Contact("JacLed1234","Jacob","Ledbetter","1234567890","Thisisaplace");
        assertAll("New Contact", () -> assertEquals("JacLed1234", newContact.getContactId()), () -> assertEquals("Jacob", newContact.getFirstName()),() -> assertEquals("Ledbetter", newContact.getLastName()), 
        () -> assertEquals("1234567890", newContact.getPhoneNbr()), () -> assertEquals("Thisisaplace", newContact.getAddress()));
    }

    @Test
    @DisplayName("You gave me a fake number (╯°□°）╯︵ ┻━┻")
    void testInvalidPhoneNumber(){
        Contact newContact = new Contact("JacLed1234","Jacob","Ledbetter","1234567890","Thisisaplace");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr("1234"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr(null));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr("J123456789"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr("123456789J"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr("12345 7890"));
    }

    @Test
    @DisplayName("You need a nick name (╯°□°）╯︵ ┻━┻")
    void testInvalidFirstName(){
        Contact newContact = new Contact("JacLed1234","Jacob","Ledbetter","1234567890","Thisisaplace");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setFirstName("LilLongName"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setFirstName(null));
    }
    @Test
    @DisplayName("Your last name crazy  (╯°□°）╯︵ ┻━┻")
    void testInvalidLastName(){
        Contact newContact = new Contact("JacLed1234","Jacob","Ledbetter","1234567890","Thisisaplace");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr("GingleHimerSchmidt"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr(null));
    }
    @Test
    @DisplayName("What kind of address is this! (╯°□°）╯︵ ┻━┻")
    void testInvalidAddress(){
        Contact newContact = new Contact("JacLed1234","Jacob","Ledbetter","1234567890","Thisisaplace");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr("ThisaplaceThisaplaceThisaplace1"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newContact.setPhoneNbr(null));
    }
    @Test
    @DisplayName("You can set that... ┬─┬ ノ( ゜-゜ノ)")
    void testCorrectUpdates(){
        Contact newContact = new Contact("JacLed1234","Jacob","Ledbetter","1234567890","Thisisaplace");
        Assertions.assertDoesNotThrow(()-> newContact.setPhoneNbr("0987654321"));
        Assertions.assertDoesNotThrow(()-> newContact.setFirstName("John"));
        Assertions.assertDoesNotThrow(()-> newContact.setLastName("Schmit"));
        Assertions.assertDoesNotThrow(()-> newContact.setAddress("Not this place again"));

    }

    @AfterAll
    @DisplayName("I broke them")
    static void teardownAll(){
        System.out.println("I finished breaking them");
    }
}
