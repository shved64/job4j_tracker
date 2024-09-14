package ru.job4j.pojo;

import java.util.Date;
import java.text.SimpleDateFormat;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Кравчук Павел Андреевич");
        student.setGroup("Java");
        student.setAdmissionDate(new Date());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String formattedDate = dateFormat.format(student.getAdmissionDate());

        System.out.println(student.getFullName() + " Группа: " + student.getGroup() + " Дата поступления: " + formattedDate);
    }
}
