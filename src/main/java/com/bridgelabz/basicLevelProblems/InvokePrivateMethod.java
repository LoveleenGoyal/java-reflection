package com.bridgelabz.basicLevelProblems;

import java.lang.reflect.Method;

class Calculator {
    private int add(int a, int b) {
        return a + b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Class<?> cls = calc.getClass();
        // Access private method
        Method method = cls.getDeclaredMethod("add", int.class, int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(calc, 5, 10);
        System.out.println("Addition result: " + result);
    }
}
