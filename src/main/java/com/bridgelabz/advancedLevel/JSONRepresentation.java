package com.bridgelabz.advancedLevel;

import java.lang.reflect.Field;

class Student {
    private String name = "Alice";
    private int id = 30;
}

public class JSONRepresentation {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            String fieldName = field.getName();
            Object fieldValue = field.get(obj);

            jsonBuilder.append("  \"").append(fieldName).append("\": ");

            if (fieldValue instanceof String) {
                jsonBuilder.append("\"").append(fieldValue).append("\"");
            } else {
                jsonBuilder.append(fieldValue);
            }

            if (i < fields.length - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student();
        String jsonString = toJson(student);
        System.out.println(jsonString);
    }
}
