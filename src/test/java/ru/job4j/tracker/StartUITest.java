package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void deleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId()), "edited item"};
        tracker.delete(item.getId());
        Item edited = tracker.findById(item.getId());
        assertThat(edited).isNull();
    }

}