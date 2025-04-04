package com.bridgelabz.basicLevelProblems;

import java.util.*;
import java.lang.reflect.*;
public class ClassInformation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the class name: ");
        String className = sc.nextLine();

        try {
            // Getting class name
            Class<?> cls = Class.forName(className);
            System.out.println("Class Name: " + cls.getName());

            // Getting class constructors
            System.out.println("\n----Constructors----");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor Name: " + constructor);
            }

            // Getting class fields
            System.out.println("\n----Fields----");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field Name: " + field);
            }

            // Getting class methods
            System.out.println("\n----Methods----");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method Name: " + method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }

}
