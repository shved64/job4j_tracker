package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class SingleTracker {

    private static SingleTracker instance = null;

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return List.of((Item) tracker.findByName(key));
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}

