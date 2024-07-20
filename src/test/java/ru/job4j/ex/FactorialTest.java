package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void whenException() {
           Factorial exception = new Factorial();
            assertThrows(IllegalArgumentException.class, () -> {
               exception.calc(-1);
            });
        }
    @Test
    void whenCorrectFactorial() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.calc(0));
        assertEquals(1, factorial.calc(1));
        assertEquals(2, factorial.calc(2));
        assertEquals(6, factorial.calc(3));
        assertEquals(24, factorial.calc(4));
        assertEquals(120, factorial.calc(5));
    }

}