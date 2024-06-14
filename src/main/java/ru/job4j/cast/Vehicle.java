package ru.job4j.cast;

public interface Vehicle {
     void move();

     public static void main(String[] args) {
          Vehicle bus = new Bus();
          Vehicle plane = new Plane();
          Vehicle train = new Train();

          Vehicle[] vehicles = new Vehicle[]{bus, plane, train};
          for (Vehicle object : vehicles) {
               object.move();
          }
     }
}