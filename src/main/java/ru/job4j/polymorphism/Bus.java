package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {

    }

    @Override
    public String passengers(String number) {
        return null;
    }

    @Override
    public String refuel(String fuel) {
        return fuel;
    }

}