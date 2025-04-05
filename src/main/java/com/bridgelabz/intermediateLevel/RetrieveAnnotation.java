package com.bridgelabz.intermediateLevel;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String name();
}

class CustomAnnotation {
    @Author(name = "Author name")
    public void myMethod() {
        System.out.println("Executing myMethod()");
    }
}

public class RetrieveAnnotation {
    public static void main(String[] args) throws Exception {
        CustomAnnotation obj = new CustomAnnotation();
        Class<?> cls = obj.getClass();

        Method method = cls.getMethod("myMethod");

        if (method.isAnnotationPresent(Author.class)) {
            Author a = method.getAnnotation(Author.class);
            System.out.println("Annotation Name: " + a.name());
        }

        method.invoke(obj);
    }

}
