package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastHappyCustomer = null;
        for (int i = 0; i < count; i++) {
            lastHappyCustomer = queue.poll();
            if (lastHappyCustomer == null) {
                return "";
            }
        }
        return lastHappyCustomer != null ? lastHappyCustomer.name()  : "";
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < count; i++) {
            Customer customer = queue.poll();
            if (customer == null) {
                return "";
            }
        }
        Customer firstUpsetCustomer = queue.poll();
        return firstUpsetCustomer != null ? firstUpsetCustomer.name() : "";
    }
}
