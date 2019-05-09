package com.sun.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
        Student stu = ac.getBean(Student.class);
        stu.setId(5);
        System.out.println(stu.getId());
    }
}
