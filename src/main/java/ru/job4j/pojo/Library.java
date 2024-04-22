package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Vendetta", 250);
        Book book2 = new Book("Power", 300);
        Book book3 = new Book("Warcraft", 350);
        Book book4 = new Book("Clean Code", 400);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages());
        }

        System.out.println("Replace Vendetta to Clean Code.");
        books[3] = books[0];
        books[0] = book4;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages());
        }
        System.out.println("цикл с выводом книг с именем Clean code.");
        for (int index = 0; index < books.length; index++) {
            if ("Clean Code".equals(books[index].getName())) {
                System.out.println(books[index].getName() + " - " + books[index].getPages());
            }
        }
    }
}