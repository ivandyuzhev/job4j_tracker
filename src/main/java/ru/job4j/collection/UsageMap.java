package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("yourEmail@yandex.ru", "Ivan Dyuzhev");
        map.put("yourEmail2@yandex.ru", "Sergei Petrov");
        map.put("yourEmail@yandex.ru", "Ivan Dyuzhev");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}