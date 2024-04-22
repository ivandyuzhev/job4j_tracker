package ru.job4j.encapsulation;

public class Config {
    String name;
    int position;
    private String[] properties;

    private Config(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(position);
    }

    private String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}