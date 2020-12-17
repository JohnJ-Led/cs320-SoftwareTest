package com.grandstrandsystems.demo;

/**
 * Task Service Test Class
 * 
 * @author john.ledbetter@snhu.edu
 * 
 * Description: This class is for testing methods developed in the TaskService.java class
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
public class TaskServiceTest {

    private TaskService testInstancService = new TaskService();
    private Task expectedTask1; // = new Task("TASK1","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
    private Task expectedTask2; // = new Task("TASK2","IsthisnameIsthisname","WhatisdescWhatisdescWhatisdescWhatisdescWhatisdesc");
    private Task expectedTask3; // = new Task("TASK3","WhyisanameWhyisaname","WhomisdescWhomisdescWhomisdescWhomisdescWhomisdesc");
    private Task actualTask;
    private Task updateTaskInfo;
    
    @BeforeAll
    static void setUpAll(){
        System.out.println("Lets begin the test");
    }
    @AfterAll
    static void tearItAll(){
        System.out.println("If we get here...we have succeed in at least getting here.");
    }



    @Nested
    class testTaskAddMethod{

        @BeforeEach
        void setUpAddTask(){
            System.out.println("Lets add a Task");
            expectedTask1 = new Task("TASK1","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
        }
        @AfterEach
        void tearDownAddTask(){
            System.out.println("We added a Task.");
            expectedTask1 = null;
        }
        @Test
        @DisplayName("Add: Test to add a Task")
        public void testAddTask(){
            actualTask = testInstancService.addTask("ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
            assertAll("Add Task", () -> assertEquals("TASK1", actualTask.taskId), () -> assertEquals("ThisisnameThisisname", actualTask.name), () -> assertEquals("ThisisdescThisisdescThisisdescThisisdescThisisdesc", actualTask.description));
            System.out.println(actualTask.taskId);
        }

        @Nested
        class testTaskGetMethod{
            @BeforeEach
            void setUpGetTask(){
                System.out.println("Lets get a Task");
                //expectedTask1 = new Task("TASK1","ThisisnameThisisname","ThisisdescThisisdescThisisdescThisisdescThisisdesc");
                expectedTask3 = new Task("TASK3","WhyisanameWhyisaname","WhomisdescWhomisdescWhomisdescWhomisdescWhomisdesc");
            }
            @AfterEach
            void tearDownGetTask(){
                System.out.println("We got the Task.");
                expectedTask1 = null;
            }
            
            @Test
            @DisplayName("Get: Test to get a Task")
            void testGetTask(){
                System.out.println(expectedTask1.taskId);
                assertNotNull(testInstancService.getTask(expectedTask1.taskId));
            }
            
            @Test
            @DisplayName("Get: Request a Task that does not exist")
            void testGetTaskException(){
                Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.getTask(expectedTask3.taskId));
            }
            @Nested
            class testTaskRemoveMethod{
                @BeforeEach
                void setUpGetTask(){
                    System.out.println("BeforeEach: Lets remove Task");
                    expectedTask2 = new Task("TASK2","IsthisnameIsthisname","WhatisdescWhatisdescWhatisdescWhatisdescWhatisdesc");
                }
                @AfterEach
                void tearDownGetTask(){
                    System.out.println("AfterEach: We removed the Task.");
                    expectedTask1 = null;
                    expectedTask2 = null;
                }
                @Test
                @DisplayName("Remove: Test remove a Task that exist")
                void testRemoveTask(){
                    String thisIDInstance = expectedTask1.taskId;
                    System.out.println(thisIDInstance);
                    testInstancService.removeTask(expectedTask1.taskId);
                    Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.removeTask(expectedTask1.taskId));

                }

                @Test
                @DisplayName("Remove: Remove a Task that DNE")
                void testRemoveTaskException(){
                   Assertions.assertThrows(IllegalArgumentException.class, () -> testInstancService.removeTask(expectedTask2.taskId));
                    
                }
            }
        }
        
        @Nested
        class testUpdateTask{
            
            
            @BeforeEach
            void setUpdateUp(){
                System.out.println("Lets Update {dsiplayName}");
                
                updateTaskInfo = testInstancService.addTask("TaskNameIsMaxLength1","This description very freaking long. Needs Longer.");

            }
            @AfterEach
            void testUpdateDown(){
                System.out.println("We Updated {dsiplayName}");
                testInstancService.removeTask(updateTaskInfo.taskId);
            }
            @Test
            @DisplayName("Update: Task Name")
            void testUpdateTaskName(){
                testInstancService.updateTaskName(updateTaskInfo.taskId, "Gerard");
                actualTask = testInstancService.getTask(updateTaskInfo.taskId);
                assertEquals("Gerard", actualTask.name);
            }
            @Test
            @DisplayName("Update: Description")
            void testUpdateTaskDescription(){
                testInstancService.updateTaskDescription(updateTaskInfo.taskId, "Butler");
                actualTask = testInstancService.getTask(updateTaskInfo.taskId);
                assertEquals("Butler", actualTask.description);
            }

    
        }
    }

}
