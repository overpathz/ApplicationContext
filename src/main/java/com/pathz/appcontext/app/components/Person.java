package com.pathz.appcontext.app.components;


import com.pathz.appcontext.app.context.Component;

@Component(name = "myPerson")
public class Person {
    public void sayHello() {
        System.out.println("Hello!");
    }

    @Override
    public String toString() {
        return "Person";
    }
}
