package com.grandstrandsystems.demo;



/**
 * Contacts Class
 * 
 * @author john.ledbetter@snhu.edu
 */
public class Contact{
    String contactId;
    String firstName;
    String lastName;
    String phoneNbr;
    String address;
    Validate testValidate = new Validate();

    /**
     * Default Constructor 
     * Set to private to prevent empty instances.
     */
    private Contact(){

    }

    /**
     * Constructor with initialization parameters.
     * @param contactId
     * @param firstName
     * @param lastName
     * @param phoneNbr
     * @param address
     */
    public Contact(String contactId, String firstName, String lastName, String phoneNbr, String address){
        this();
        if(testValidate.validate(contactId, 10, "id")){
            this.contactId = contactId;
        }
        if(testValidate.validate(firstName, 10, "first name")){
        this.firstName = firstName;
        }
        if(testValidate.validate(lastName, 10, "last name")){
            this.lastName = lastName;
        }
        if(testValidate.validate(phoneNbr, 10, "phone number")){
        this.phoneNbr = phoneNbr;
        }
        if(testValidate.validate(address, 30, "address")){
        this.address = address;
        }
    }
    /**
     * ContactId Accessor
     * @return contactId
     */
    public String getContactId(){
        return contactId;
    }

    /**
     * FistName Accessor
     * @return firstName
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * LastName Accessor
     * @return lastName
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * Phone Number Accessor
     * @return phoneNbr
     */
    public String getPhoneNbr(){
        return phoneNbr;
    }
    /**
     * Address Accessor
     * @return address
     */
    public String getAddress(){
        return address;
    }
    /**
     * First Name Mutator
     * @param aFName
     */
    public void setFirstName(String aFName){
        if(testValidate.validate(aFName, 10, "id")){
            this.firstName = aFName;
        }
    }
    /**
     * Last Name Mutator 
     * @param aLName
     */
    public void setLastName(String aLName){
        if(testValidate.validate(aLName, 10, "last name")){
            this.lastName = aLName;
        }
    }

    /**
     * Phone Number Mutator
     * @param aPNbr
     */
    public void setPhoneNbr(String aPNbr){
        if(testValidate.validate(aPNbr, 10, "phone number")){
            this.phoneNbr = aPNbr;
            }
    }

    /**
     * Address Mutator
     * @param aAddress
     */
    public void setAddress(String aAddress){
        if(testValidate.validate(aAddress, 30, "address")){
            this.address = aAddress;
            }
    }    
}
