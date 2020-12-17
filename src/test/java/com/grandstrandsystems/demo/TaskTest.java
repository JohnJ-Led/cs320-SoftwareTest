package com.grandstrandsystems.demo;

/**
 * Task Class Test
 * Author john.ledbetter@snhu.edu
 * 
 * Description: This class is for testing methods developed in the Task.java class
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
class TaskTest {
    @BeforeAll
    static void setupAll(){
        System.out.println("Start test failures");
    }


    @BeforeEach
    void setupEach(){
        System.out.println("Start each test failures");
    }

    @Test
    @DisplayName("Your Task Info is to Long (╯°□°）╯︵ ┻━┻")
    void testTaskClassToLong(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Task("1234567890","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc1"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Task("1234567890","ThisisnameThisisname1","ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Task("12345678901","Jacob","ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        
    }
    
    @Test
    @DisplayName("Your Task Info is Null (╯°□°）╯︵ ┻━┻")
    void testTaskClassNull(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Task(null,"ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Task("1234567890",null,"ThisisdescThisisdescThisisdescThisisdescThisisdesc"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Task("1234567890","ThisisnameThisisname",null));
    }

    @Test
    @DisplayName("Your Task Info is Good... ┬─┬ ノ( ゜-゜ノ)")
    void testTaskClass(){
        Task newTask = new Task("1234567890","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
        assertAll("New Task", () -> assertEquals("1234567890", newTask.getTaskId()), () -> assertEquals("ThisisnameThisisname", newTask.getName()),() -> assertEquals("ThisisdescThisisdescThisisdescThisisdescThisisdesc", newTask.getDescription()));
    }


    @Test
    @DisplayName("You need a nick name (╯°□°）╯︵ ┻━┻")
    void testInvalidName(){
        Task newTask = new Task("1234567890","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newTask.setName("ThisisnameThisisnameNO"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newTask.setName(null));
    }
    @Test
    @DisplayName("Your Description is crazy  (╯°□°）╯︵ ┻━┻")
    void testInvalidDescription(){
        Task newTask = new Task("1234567890","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newTask.setDescription("ThisisdescThisisdescThisisdescThisisdescThisisdescNo"));
        Assertions.assertThrows(IllegalArgumentException.class,()-> newTask.setDescription(null));
    }

    @Test
    @DisplayName("You can set that... ┬─┬ ノ( ゜-゜ノ)")
    void testCorrectUpdates(){
        Task newTask = new Task("JacLed1234","Jacob","Ledbetter");
        Assertions.assertDoesNotThrow(()-> newTask.setName("John"));
        Assertions.assertDoesNotThrow(()-> newTask.setDescription("Schmit"));
    }

    @AfterAll
    @DisplayName("I broke them")
    static void teardownAll(){
        System.out.println("I finished breaking them");
    }

}
