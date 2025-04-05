package com.bridgelabz.intermediateLevel;

import java.lang.reflect.Method;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}
public class InvokeMethod {
    public static void main(String[] args) throws Exception {
        MathOperations mop = new MathOperations();

        Class<?> cls = mop.getClass();
        System.out.println("Class Name: " + cls.getName());

        Method method1 = cls.getMethod("add", int.class, int.class);
        int addResult = (int) method1.invoke(mop,5, 10);
        System.out.println("Addition result: " + addResult);

        Method method2 = cls.getMethod("subtract", int.class, int.class);
        int subResult = (int) method2.invoke(mop,5, 10);
        System.out.println("Subtraction result: " + subResult);

        Method method3 = cls.getMethod("multiply", int.class, int.class);
        int multiplyResult = (int) method3.invoke(mop, 5, 10);
        System.out.println("Multiplication result: " + multiplyResult);

    }
}
