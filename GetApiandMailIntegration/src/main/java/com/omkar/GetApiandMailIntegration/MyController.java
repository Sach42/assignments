package com.omkar.GetApiandMailIntegration;

import org.omkar.MailHandler;
import org.omkar.Sub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//restcontroller is what is checked when we hit get or any crud on post man and in this curds with matching commands are found like how "objects" is searched when on postman
@RestController

public class MyController {

    //autowire will basically act as a connector and will help refernce variable connect to object of same type
    @Autowired
    private MyObject myObject;


   public static Sub email;

   //getmapping will be search for get type of search on post man and basically will get the output for us
    @GetMapping("objects")
    public String getObjects() {
        // Use the created objects
        String myObjectAsString = myObject.toString();

        // Send the objects as strings via email
        email.setsub(myObjectAsString);
        MailHandler MailHandler = new MailHandler();

        MailHandler.sendmail();
        return myObjectAsString;
    }
}

