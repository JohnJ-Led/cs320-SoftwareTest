package com.grandstrandsystems.demo;

/**
 * Task Class
 * 
 * @author john.ledbetter@snhu.edu
 */

public class Task {
    String taskId;
    String name;
    String description;
    Validate testValidate = new Validate();

    /**
     * Default Constructor 
     * Set to private to prevent empty instances.
     */
    private Task(){

    }

    /**
     * Constructor with initialization parameters.
     * @param taskId
     * @param name
     * @param description
     */
    public Task(String TaskId, String name, String description){
        this();
        if(testValidate.validate(TaskId, 10, "id")){
            this.taskId = TaskId;
        }
        if(testValidate.validate(name, 20, "name")){
            this.name = name;
        }
        if(testValidate.validate(description, 50, "description")){
            this.description = description;
        }
        
        

    }
    /**
     * TaskId Accessor
     * @return TaskId
     */
    public String getTaskId(){
        return taskId;
    }

    /**
     * FistName Accessor
     * @return firstName
     */
    public String getName(){
        return name;
    }
    /**
     * LastName Accessor
     * @return lastName
     */
    public String getDescription(){
        return description;
    }
   
    /**
     * Name Mutator
     * @param aName
     */
    public void setName(String aName){
        if(testValidate.validate(aName, 20, "name")){
            this.name = aName;
        }
    }
    /**
     * Last Name Mutator 
     * @param aLName
     */
    public void setDescription(String aDescription){
        if(testValidate.validate(aDescription, 50, "description")){
            this.description = aDescription;
        }
    }
}
