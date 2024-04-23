package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Дюжев Иван Иванович");
        student.setGroup("2");
        student.setDate("22.04.2024");
        System.out.println("студент: " + student.getName() + System.lineSeparator() + "группа: " + student.getGroup() + System.lineSeparator() + "дата поступления: " + student.getDate());
    }
}