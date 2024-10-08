package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, представляющий банковский сервис
 */
public class BankService {
    /**
     * Хранит пользователей и их счета в виде Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления нового пользователя в банк
     * @param user объект нового пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод для удаления пользователя по паспорту
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод для добавления счета пользователю
     * Если пользователь найден,получаем список его счетов
     * Проверяем что такого счета еще нет, добавляем новый счет
     * @param passport номер паспорта пользователя
     * @param account объект счета еоторый необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя по паспорту
     * Перебираем всех пользователей в Map
     * @param passport номер паспорта пользователя
     * @return Если находим пользователя с указанным паспортом, возвращаем его
     * Если пользователь не найден, возвращаем null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод для поиска счета по реквизитам
     * Находим пользователя по паспорту
     * Если пользователь найден, Получаем список его счетов
     * @param passport номер паспорта пользователя, чей счет необходимо найти
     * @param requisite реквизиты счета, который требуется найти
     * @return Перебираем счета, Если находим счет с указанными реквизитами, возвращаем его
     * Если счет не найден, возвращаем null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перевода денег с одного счета на другой
     * @param sourcePassport номер паспорта источника, с которого переводятся деньги
     * @param sourceRequisite реквизиты счета источника
     * @param destinationPassport номер паспорта получателя, на который переводятся деньг
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма, которую необходимо перевести
     * @return true, если перевод был успешным; false в противном случаи
     * Метод выполняет проверку на:
     * Положительная сумма для перевода.
     * Существование источника и получателя
     * Достаточность средств на счету источника
     * Если все условия выполнены, сумма вычитается из счета источника и добавляется на счет получателя.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;

        if (amount <= 0) {
            return false;
        }

        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }

        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}