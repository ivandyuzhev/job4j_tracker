package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.sort;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenItemSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Piter Parker", 2),
                new Item("Sara Conor", 1),
                new Item("Ralf Ringer", 3),
                new Item("Lara Croft", 4),
                new Item("Lara Soft", 5)
        );
        List<Item> expected = Arrays.asList(
                new Item("Lara Croft", 4),
                new Item("Lara Soft", 5),
                new Item("Piter Parker", 2),
                new Item("Ralf Ringer", 3),
                new Item("Sara Conor", 1)
        );
        sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Piter Parker", 2),
                new Item("Sara Conor", 1),
                new Item("Ralf Ringer", 3),
                new Item("Lara Croft", 4),
                new Item("Lara Soft", 5)
        );
        List<Item> expected = Arrays.asList(
                new Item("Sara Conor", 1),
                new Item("Ralf Ringer", 3),
                new Item("Piter Parker", 2),
                new Item("Lara Soft", 5),
                new Item("Lara Croft", 4)
        );
        sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}