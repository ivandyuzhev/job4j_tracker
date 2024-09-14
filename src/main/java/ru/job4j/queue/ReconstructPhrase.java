package ru.job4j.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder sb = new StringBuilder();
        int count = evenElements.size();
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                sb.append((evenElements.pollFirst()));
            } else {
                evenElements.pollFirst();
            }
        }
        return sb.toString();
    }

    private String getDescendingElements() {
        StringBuilder sb = new StringBuilder();
        while (!descendingElements.isEmpty()) {
            sb.append(descendingElements.pollLast());
        }
        return sb.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}