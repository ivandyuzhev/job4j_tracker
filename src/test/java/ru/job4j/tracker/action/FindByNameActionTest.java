package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FindByNameActionTest {
    @Test
    void whenFindByNameActionExecutesSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Input input = new MockInput(
                new String[]{"0", (one.getName()), "1"}
        );

        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new ExitAction(output)
        );

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}