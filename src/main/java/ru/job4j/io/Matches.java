package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            switch (count) {
                case 1 -> System.out.println(player + " забери последнюю спичку");
                case 2 -> System.out.println(player + " введите число от 1 до 2");
                default -> System.out.println(player + " введите число от 1 до 3:");
            }
            int matches = Integer.parseInt(input.nextLine());
            boolean valid = matches > 0 && matches <= Math.min(3, count);
            if (valid) {
                count -= matches;
                turn = !turn;
            } else {
                System.out.println("Введите верное число");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }

    }
}