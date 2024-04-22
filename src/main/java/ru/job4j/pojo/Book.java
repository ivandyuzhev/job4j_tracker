package ru.job4j.pojo;

import java.util.Objects;

public class Book {
    private String name;
    private int pages;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book cleanCode = (Book) o;
        return pages == cleanCode.pages && Objects.equals(name, cleanCode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages);
    }

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}