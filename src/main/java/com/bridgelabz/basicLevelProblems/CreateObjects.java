package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.Constructor;

class Student {
    private String id;
    private String name;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Student Id: " + id);
        System.out.println("Student Name: " + name);
    }
}
public class CreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Student.class;

        // Getting constructor
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class, String.class);

        // create instance dynamically
        Student student = (Student) constructor.newInstance("S101", "Loveleen");

        student.display();
    }
}
