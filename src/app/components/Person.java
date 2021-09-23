package app.components;

import app.context.Component;

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
