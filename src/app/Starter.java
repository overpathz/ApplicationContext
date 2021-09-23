package app;

import app.components.Car;
import app.components.Person;
import app.context.ApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext("app.components");
        Person person = (Person) applicationContext.getComponent("myPerson");
        person.sayHello();
    }
}
