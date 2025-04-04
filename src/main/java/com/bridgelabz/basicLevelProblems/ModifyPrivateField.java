package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;

    Person() {
        this.name = null;
        this.age = 0;
    }
}
public class ModifyPrivateField {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Class<?> cls = Class.forName("com.bridgelabz.basicLevelProblems.Person");
        System.out.println("Class Name: " + cls.getName());

        Person person = new Person();

        // Access private fields
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // allow access to private field
            field.setAccessible(true);

            // get field value
            System.out.println("\nField Name: " + field.getName());
            System.out.println("Old value: " + field.get(person));

            // modify field value
            if (field.getType() == String.class) {
                field.set(person, "Alice");
            } else if (field.getType() == int.class) {
                field.set(person, 30);
            }

            System.out.println("New value: " + field.get(person));
        }
    }
}
