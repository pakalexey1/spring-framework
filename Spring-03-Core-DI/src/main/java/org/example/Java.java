package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java {

//    Field injection is not recommended
//    @Autowired
//    OfficeHours officeHours;

    //Constructor Injection
    OfficeHours officeHours;

    @Autowired //Optional annotation because there is only one constructor
    public Java(OfficeHours officeHours){
        this.officeHours=officeHours;
    }
    public void getTeachingHours(){
        System.out.println("Weekly teaching hours: " + (20 + officeHours.getHours()));
    }
}
