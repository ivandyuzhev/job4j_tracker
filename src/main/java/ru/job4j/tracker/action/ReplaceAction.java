package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменение заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
       output.println("=== Изменение заявки ===");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        boolean isReplaced = tracker.replace(id, item);
        if (isReplaced) {
           output.println("Заявка изменена успешно.");
        } else {
           output.println("Ошибка: Заявка с данным id не найдена.");
        }
        return true;
    }
}