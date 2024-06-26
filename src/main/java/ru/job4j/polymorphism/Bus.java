package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(byte number) {
        System.out.println(number + " пассажиров в автобусе");
    }

    @Override
    public double refuel(int fuel) {
        double cost = 51.42;
        return fuel * cost;
    }
}