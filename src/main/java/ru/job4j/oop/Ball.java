package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condtion) {
        if (condtion) {
            System.out.println("ball was eaten");
        } else {
            System.out.println("ball run away");
        }
    }
}