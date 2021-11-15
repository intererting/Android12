package com.example.android12;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author yiliyang
 * @version 1.0
 * @date 2021/9/7 上午10:29
 * @since 1.0
 */
public class JUnitTest {

    @Test
    public void test() {

//        final String a = "a";
//        final String b = "b";
//        String c = a + b;
//        String d = "ab";
//        System.out.println(c == d);

//        Person person = new Person("yuliyang");
//        try {
//            Field field = Person.class.getDeclaredField("name");
//            field.setAccessible(true);
//            field.set(person, "changed");
//            System.out.println(person.name);
//            System.out.println(person.getName());
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}

class Person {
    final String name;

    String getName() {
        return name;
    }

    Person(String name) {
        this.name = name;
    }
}

class Child extends Person {

    Child(String name) {
        super(name);
    }
}