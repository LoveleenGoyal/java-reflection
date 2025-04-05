package com.bridgelabz.intermediateLevel;

import java.lang.reflect.Method;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the method name: ");
        String methodName = sc.nextLine();

        System.out.print("Enter the 1st number: ");
        int a = sc.nextInt();
        System.out.print("Enter the 2nd number: ");
        int b = sc.nextInt();

        Method method = cls.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(mop,a, b);
        System.out.println(method.getName() + " result: " + result);

//        Method method2 = cls.getMethod("subtract", int.class, int.class);
//        int subResult = (int) method2.invoke(mop,5, 10);
//        System.out.println("Subtraction result: " + subResult);
//
//        Method method3 = cls.getMethod("multiply", int.class, int.class);
//        int multiplyResult = (int) method3.invoke(mop, 5, 10);
//        System.out.println("Multiplication result: " + multiplyResult);

    }
}
