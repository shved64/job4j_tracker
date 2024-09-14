package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Кравчук Павел Андреевич");
        student.setGroup("Java");
        student.setAdmissionDate(new Date());

        System.out.println(student.getFullName() + " Группа: " + student.getGroup() + " Дата поступления: " + student.getAdmissionDate());
    }
}
