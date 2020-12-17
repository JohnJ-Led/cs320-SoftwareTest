package com.grandstrandsystems.demo;
/**
 * Contact Service Test Class
 * 
 * @author john.ledbetter@snhu.edu
 * 
 * Description: This class is for testing methods developed in the ContactService.java class
 * 
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.MatcherAssert.assertThat;
//import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ContactServiceTest {
    
        private Contact expectedContact1; //= new Contact("JacLed7890", "Jacob", "Ledbetter", "1234567890", "Whatisthisplace");
        private Contact expectedContact2; //= new Contact("JacLed4321","Jacob","Ledbetter","0987654321","Thisisaplace");
        private Contact expectedContact3; //= new Contact("KinLeo3000","King","Leonidas","3003003000","ThisisSPARTA");
        private ContactService testInstancService = new ContactService();
        private Contact actualContact;
        
        @BeforeAll
        static void setUpAll(){
            System.out.println("Lets begin the test");
        }
        @AfterAll
        static void tearItAll(){
            System.out.println("If we get here...we have succeed in at least getting here.");
        }
        
        
        @Nested
        class testContactAddMethod{
            
            @BeforeEach
            void setUpAddContact(){
                System.out.println("Lets add a contact");
                expectedContact1 = new Contact("JacLed7890", "Jacob", "Ledbetter", "1234567890", "Whatisthisplace");
                expectedContact2 = new Contact("JacLed4321","Jacob","Ledbetter","0987654321","Thisisaplace");
            }
            
            @AfterEach
            void tearDownAddContact(){
                System.out.println("We added a contact.");
                expectedContact1 = null;
                expectedContact2 = null;
            }
            
            @Test
            @DisplayName("Add: Test to add a contact")
            public void testAddContact(){
                actualContact = testInstancService.addContact("Jacob", "Ledbetter", "1234567890", "Whatisthisplace");
                assertThat(actualContact, samePropertyValuesAs(expectedContact1));
                System.out.println(actualContact.contactId);
                
            }
            
            @Test
            @DisplayName("Add: Test to add a second contact")
            public void testAddMultipleContacts(){
                actualContact = testInstancService.addContact("Jacob", "Ledbetter","0987654321","Thisisaplace");
                assertThat(actualContact, samePropertyValuesAs(expectedContact2));
                System.out.println(actualContact.contactId);
                
            }

            @Nested
            class testContactGetMethod{
                @BeforeEach
                void setUpGetContact(){
                    System.out.println("Lets get a contact");
                    expectedContact3 = new Contact("KinLeo3000","King","Leonidas","3003003000","ThisisSPARTA");
                }
                @AfterEach
                void tearDownGetContact(){
                    System.out.println("We got the contact.");
                    expectedContact3 = null;
                }
                @Test
                @DisplayName("Get: Test to get a contact")
                void testGetContact(){
                    System.out.println(expectedContact1.contactId);
                    assertNotNull(testInstancService.getContact(expectedContact1.contactId));
                }
                
                @Test
                @DisplayName("Get: Request a contact that does not exist")
                void testGetContactException(){
                    Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.getContact(expectedContact3.contactId));
                }


                @Nested
                class testContactRemoveMethod{
                    @BeforeEach
                    void setUpRemoveContact(){
                        System.out.println("BeforeEach: Lets remove contact");
                    }
                    @AfterEach
                    void tearDownRemoveContact(){
                        System.out.println("AfterEach: We removed the contact.");
                    }
                    @Test
                    @DisplayName("Remove: Test remove a contact that exist")
                    void testRemoveContact(){
                        testInstancService.removeContact(expectedContact1.contactId);
                        Assertions.assertThrows(IllegalArgumentException.class,() -> testInstancService.removeContact(expectedContact1.contactId));
                    }

                    @Test
                    @DisplayName("Remove: Remove a contact that DNE")
                    void testRemoveContactException(){
                        Assertions.assertThrows( IllegalArgumentException.class, () -> testInstancService.removeContact(expectedContact3.contactId));   
                    }
                }

                @Nested
                class testUpdateContact{
                    
                    
                    @BeforeEach
                    void setUpdateUp(){
                        System.out.println("Lets Update {dsiplayName}");
                        testInstancService.addContact("King","Leonidas","3003003000","ThisisSPARTA");
        
                    }
                    @AfterEach
                    void testUpdateDown(){
                        System.out.println("We Updated {dsiplayName}");
                        testInstancService.removeContact(expectedContact3.contactId);
                    }
                    @Test
                    @DisplayName("Update: First Name")
                    void testUpdateContactFName(){
                        testInstancService.updateContactFName(expectedContact3.contactId, "Gerard");
                        actualContact = testInstancService.getContact(expectedContact3.contactId);
                        assertEquals("Gerard", actualContact.firstName);
                    }
                    @Test
                    @DisplayName("Update: Last Name")
                    void testUpdateContactLName(){
                        testInstancService.updateContactLName(expectedContact3.contactId, "Butler");
                        actualContact = testInstancService.getContact(expectedContact3.contactId);
                        assertEquals("Butler", actualContact.lastName);
                    }
                    @Test
                    @DisplayName("Update: PhoneNbr")
                    void testUpdateContactPhoneNbr(){
                        testInstancService.updateContactPhoneNbr(expectedContact3.contactId, "8008675309");
                        actualContact = testInstancService.getContact(expectedContact3.contactId);
                        assertEquals("8008675309", actualContact.phoneNbr);
                    }
                    @Test
                    @DisplayName("Update: Address")
                    void testUpdateContactAddress(){
                        testInstancService.updateContactAddress(expectedContact3.contactId, "HollyWood");
                        actualContact = testInstancService.getContact(expectedContact3.contactId);
                        assertEquals("HollyWood", actualContact.address);
                    }
            
                }
            }
    }
}
