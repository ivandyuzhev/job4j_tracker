package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void whenException() {
           Factorial exception = new Factorial();
            assertThrows(IllegalArgumentException.class, () -> {
               exception.calc(-1);
            });
        }

}