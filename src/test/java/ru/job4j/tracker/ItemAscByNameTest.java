package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemAscByNameTest {

    @Test
    public void itemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Pavel"),
                new Item("Sergey"),
                new Item("Ivan"));

        Collections.sort(items);

        List<Item> expected = Arrays.asList(
                new Item("Ivan"),
                new Item("Pavel"),
                new Item("Sergey")
        );
        assertEquals(items, expected);
    }

    @Test
    public void itemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Pavel"),
                new Item("Sergey"),
                new Item("Ivan"));

        items.sort(new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item("Sergey"),
                new Item("Pavel"),
                new Item("Ivan")
        );
        assertEquals(items, expected);
    }
}