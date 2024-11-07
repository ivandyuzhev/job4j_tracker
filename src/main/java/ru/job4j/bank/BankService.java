package ru.job4j.bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы.
 * модель может: регистрировать, удалять пользователя, добавлять ему
 * банковский счет, переводить деньги между счетами.
 * @author Ivan Dyuzhev
 * version 1.0
 */
public class BankService {

    /**
     * Хранение данных пользователей и их счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляется его в коллекцию,
     * если такого пользлваеля еще нет.
     * @param user - пользоваетль.
     */
    public void addUser(User user) {
        users.put(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспортные данные и удаляет пользователя из коллекции
     * с таким паспортом
     * @param passport - паспортные данные пользователя.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и его счет.
     * В методе осуществляется поиск пользователя по данным паспорта, в случае, если такой
     * пользователь в коллекции есть - проводится проверка на наличие аналогичного счета.
     * В случае отсутствия счета с указанными данными - пользователю добавляется счёт.
     * @param passport - паспортные данные пользователя
     * @param account - счет пользователя (номер и баланс)
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccount = getAccounts(user);
            if (!userAccount.contains(account)) {
                userAccount.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспортные данные и ищет по ним пользователя в коллекции.
     * @param passport - паспортные данные пользователя
     * @return возвращает пользователя или null в случае отсутствия такого пользователя
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User result : users.keySet()) {
            if (result.getPassport().equals(passport)) {
                user = result;
                break;
            }
        }
        return user;
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и реквизит счета.
     * Ищет пользователя по паспорту, если такой есть - ищет его счет по номеру.
     * @param passport - паспортные данные пользователя
     * @param requisite - номер счета пользователя
     * @return возвращает данные счета или null в случае отсутсвия.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account userAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = getAccounts(user);
            for (Account result : userAccounts) {
                if (result.getRequisite().equals(requisite)) {
                    userAccount = result;
                    break;
                }
            }
        }
        return userAccount;
    }

    /**
     * Метод принимает: паспорт и реквизит счета отправителя, паспорт и номер счета получателя,
     * сумму перевода. Если находит счета отправителя и получателя, проверяет наличие средств
     * и осуществляет перевод получателю.
     * @param sourcePassport - паспортные данные отправителя
     * @param sourceRequisite - номер счета отправителя
     * @param destinationPassport - паспортные данные получателя
     * @param destinationRequisite - номер счета получателя
     * @param amount - сумма перевода
     * @return возвращает true при успешном переводе, false - при неудачном
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null && destination != null) {
            if (source.getBalance() >= amount) {
                source.setBalance(source.getBalance() - amount);
                destination.setBalance(destination.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход пользователя
     * @param user - пользователь
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}