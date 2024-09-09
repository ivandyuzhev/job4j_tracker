package ru.job4j.queue;

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
        }
        return lastHappyCustomer != null ? lastHappyCustomer.name() : "";
    }

    public String getFirstUpsetCustomer() {
        Customer firstUpsetCustomer = null;
        for (int i = 0; i < count + 1; i++) {
            firstUpsetCustomer = queue.poll();
        }
        return firstUpsetCustomer != null ? firstUpsetCustomer.name() : "";
    }
}