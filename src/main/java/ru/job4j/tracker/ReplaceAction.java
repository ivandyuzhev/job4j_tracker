package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменение заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Изменение заявки ===");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        boolean isReplaced = tracker.replace(id, item);
        if (isReplaced) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка: Заявка с данным id не найдена.");
        }
        return true;
    }
}