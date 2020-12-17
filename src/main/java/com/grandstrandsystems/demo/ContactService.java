package com.grandstrandsystems.demo;
/**
 * Contact Service Class
 * 
 * @author john.ledbetter@snhu.edu
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


 public class ContactService{

//Initiate List and Service
private static List<Contact> contacts = new ArrayList<Contact>();
private static ContactService instance = new ContactService();
String theirContactId;


/**
 * Get the instance of the contact service
 * 
 * @return instance
 */
public static ContactService getService(){
    return instance;
}

//Need to create multiple new contacts with unique ID
/**
 * Adds a contact if one does not exist for ID generated, returns contact if ID exist already
 * @param theirFirstName
 * @param theirLastName
 * @param theirPhoneNbr
 * @param theirAddress
 * @return
 */
public Contact addContact(String theirFirstName, String theirLastName, String theirPhoneNbr, String theirAddress){
    //Local instance of contact
    Contact contact = null;
    int i = 0;

    //return the instance of contact
    Iterator<Contact> hasInstance = contacts.iterator();
    
    //Create Unique ID
    //FIXME: Does not take into account lengths less than 3/4 or validate uniqueness here.  
    if(theirFirstName.length() >= 3 && theirLastName.length() >=3 && theirPhoneNbr.length() >=4){
        theirContactId = theirFirstName.substring(0,3) + theirLastName.substring(0, 3) + theirPhoneNbr.substring(theirPhoneNbr.length()-4, theirPhoneNbr.length());
    }
    //Check if exist
    while(hasInstance.hasNext()){
        String tempId = hasInstance.next().getContactId();
        if(theirContactId.equals(tempId)){
            contact = getContact(i);
        }
        i++;
    }
    //Add if doesn't exist
    if(contact == null){
        contact = new Contact(theirContactId, theirFirstName, theirLastName, theirPhoneNbr, theirAddress);
        contacts.add(contact);
    }
    else{
        throw new IllegalStateException(String.format("User '%s' already exist.", contact.contactId));
    }

    return contact;
}
/**
 * Removes contact from the contacts instance
 * @param cId
 */
public void removeContact(String cId){
    Contact contact = getContact(cId);
    contacts.remove(contact);
}

/**
 * Returns the contact instance at the index
 * @param index
 * @return contact instance at index
 */
public Contact getContact(int index){
    return contacts.get(index);
}

/**
 * Returns the contact instance based on contactId
 * @param cId
 * @return contact
 */
public Contact getContact(String cId){

    Contact contact = null;
    int i = 0;

        //return the instance of contact
        Iterator<Contact> hasInstance = contacts.iterator();
        //Loop through instance and return contact
        while(hasInstance.hasNext()){
            String tempId = hasInstance.next().getContactId();
            if(cId.equals(tempId)){
                contact = getContact(i);
            }
            i++;
        }

        if(contact == null){
            throw new IllegalArgumentException(String.format("User '%s' Not Found", cId));
        }
    return contact;
}
/**
 * Updates a specfic contact first name in the contacts instance
 * @param cId
 * @param name
 */
public void updateContactFName(String cId, String name){
    Contact contact = getContact(cId);
    contact.setFirstName(name);
}
/**
 *  Updates a specfic contact last name in the contacts instance
 * @param cId
 * @param name
 */
public void updateContactLName(String cId, String name){
    Contact contact = getContact(cId);
    contact.setLastName(name);
}
/**
 *  Updates a specfic contact phone number in the contacts instance
 * @param cId
 * @param phoneNbr
 */
public void updateContactPhoneNbr(String cId, String phoneNbr){
    Contact contact = getContact(cId);
    contact.setPhoneNbr(phoneNbr);
}
/**
 *  Updates a specfic contact address in the contacts instance
 * @param cId
 * @param address
 */
public void updateContactAddress(String cId, String address){
    Contact contact = getContact(cId);
    contact.setAddress(address);
}

}