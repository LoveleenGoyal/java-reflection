package com.bridgelabz.intermediateLevel;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}
public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        Class<?> cls = config.getClass();
        System.out.println("Class Name: " + cls.getName());

        Field field = cls.getDeclaredField("API_KEY");
        System.out.println("Field name: " + field.getName());
        field.setAccessible(true);
        System.out.println("Old value of field: " + field.get(config));

        field.set(config, "NEW_API_KEY_123");
        System.out.println("New value of field: " + field.get(config));
    }
}
