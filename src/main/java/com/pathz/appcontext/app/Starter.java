package com.pathz.appcontext.app;



import com.pathz.appcontext.app.components.Car;
import com.pathz.appcontext.app.components.Person;
import com.pathz.appcontext.app.context.ApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext("com.pathz.appcontext.app.components");
        Person person = (Person) applicationContext.getComponent("myPerson");
        Car car = applicationContext.getComponent("myCar", Car.class);
        System.out.println(car);
    }
}
