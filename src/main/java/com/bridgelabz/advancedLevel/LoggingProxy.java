package com.bridgelabz.advancedLevel;

import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class Hello implements Greeting {
    public void sayHello() {
        System.out.println("Hello world");
    }
}

class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call...");
        Object result = method.invoke(target, args);
        System.out.println("After method call...");
        return result;
    }
}
public class LoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = new Hello();

        Greeting proxyInstance = (Greeting)Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );
        proxyInstance.sayHello();
    }
}
