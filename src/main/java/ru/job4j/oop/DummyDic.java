package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic forestFool = new DummyDic();
        System.out.println(forestFool.engToRus("Get Over Here"));
    }
}