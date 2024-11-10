package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x * x - 3 * x + 5);
        List<Double> expected = Arrays.asList(40D, 59D, 82D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenIndicativeFunctionThenIndicativeResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(0.5, x));
        List<Double> expected = Arrays.asList(0.03125D, 0.015625D, 0.0078125D);
        assertThat(result).containsAll(expected);
    }
}