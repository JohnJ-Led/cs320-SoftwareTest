package com.grandstrandsystems.demo;
/**
 * Task Service Class
 * 
 * @author john.ledbetter@snhu.edu
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class TaskService{

//Initiate List and Service
private static List<Task> tasks = new ArrayList<Task>();
private static TaskService instance = new TaskService();
String theTaskId;


/**
 * Get the instance of the Task service
 * 
 * @return instance
 */
public static TaskService getService(){
    return instance;
}

//Need to create multiple new Tasks with unique ID
/**
 * Adds a Task if one does not exist for ID generated, returns Task if ID exist already
 * @param theName
 * @param theDescription
 * @return
 */
public Task addTask(String theName, String theDescription){
    //Local instance of Task
    Task task = null;
    String TaskSeed = "TASK";
    int taskIncrement;

    //Create Unique ID. Assumption is that no duplicate task will be made. 
    //If two task have the same name and descritpion they are seperate objects.
    if(tasks.size() == 0){
        theTaskId = TaskSeed+ "1";

    }
    else{
        taskIncrement = tasks.size() + 1;
        if(taskIncrement > 99999){
            throw new IndexOutOfBoundsException("MAX Number of Task reached");
        }
        theTaskId = TaskSeed + Integer.toString(taskIncrement);
    }

    //Add if doesn't exist
    if(task == null){
        task = new Task(theTaskId, theName, theDescription);
        tasks.add(task);
    }

    return task;
}

/**
 * Removes Task from the Tasks instance
 * @param cId
 */
public void removeTask(String cId){
    Task Task = getTask(cId);
    tasks.remove(Task);
}

/**
 * Returns the Task instance at the index
 * @param index
 * @return Task instance at index
 */
public Task getTask(int index){
    return tasks.get(index);
}

/**
 * Returns the Task instance based on TaskId
 * @param cId
 * @return Task
 */
public Task getTask(String cId){

    Task task = null;
    int i = 0;

        //return the instance of Task
        Iterator<Task> hasInstance = tasks.iterator();
        //Loop through instance and return Task
        while(hasInstance.hasNext()){
            String tempId = hasInstance.next().getTaskId();
            if(cId.equals(tempId)){
                task = getTask(i);
            }
            i++;
        }

        if(task == null){
            throw new IllegalArgumentException(String.format("Task '%s' Not Found", cId));
        }
    return task;
}
/**
 * Updates a specfic Task first name in the Tasks instance
 * @param cId
 * @param name
 */
public void updateTaskName(String cId, String name){
    Task task = getTask(cId);
    task.setName(name);
}
/**
 *  Updates a specfic Task last name in the Tasks instance
 * @param cId
 * @param name
 */
public void updateTaskDescription(String cId, String description){
    Task task = getTask(cId);
    task.setDescription(description);
}

}
