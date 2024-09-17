package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        Item item1 = new Item();
        LocalDateTime createdDate = item.getCreated();
        System.out.println(item1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedDate = createdDate.format(formatter);
        System.out.println(formattedDate);
    }
}
