package ru.sgu.presentation.bank;

import ru.sgu.presentation.bank.dao.AccountDao;
import ru.sgu.presentation.bank.dao.TransferDao;
import ru.sgu.presentation.bank.dao.UserDao;
import ru.sgu.presentation.bank.error.UserNotFoundException;
import ru.sgu.presentation.bank.model.AccCodeType;
import ru.sgu.presentation.bank.model.Account;
import ru.sgu.presentation.bank.model.Transfer;
import ru.sgu.presentation.bank.model.User;
import ru.sgu.presentation.bank.service.AccountService;
import ru.sgu.presentation.bank.service.TransferService;
import ru.sgu.presentation.bank.service.UserService;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        AccountDao accountDao = new AccountDao(userDao);
        TransferDao transferDao = new TransferDao(accountDao);
        UserService userService = new UserService(userDao);
        TransferService transferService = new TransferService(transferDao);
        AccountService accountService = new AccountService(accountDao);
        transferService.setAccountService(accountService);
        accountService.setTransferService(transferService);
        System.out.println("Добро пожаловать в консольное приложение по управлению счетами!");
        User authorizedUser = null;
        String error = null;
        while (true) {
            if (!Objects.isNull(error) && !error.equals("")) {
                System.out.printf("ОШИБКА: %s\n", error);
            }
            error = null;
            System.out.println("0 - выйти из приложения");
            try {
                if (authorizedUser != null) {
                    Set<Account> myAccounts = accountService.getAllByUserId(authorizedUser.getId());
                    System.out.println("Ваши счета: ");
                    System.out.println("=============");
                    for (Account curAccount : myAccounts) {
                        System.out.println(curAccount);
                        System.out.println("=============");
                    }
                    System.out.println("1 - Создать аккаунт");
                    System.out.println("2 - Пополнить счет");
                    System.out.println("3 - Перевести средства другому аккаунту по номеру телефона");
                    System.out.println("4 - Просмотреть историю операций");
                    System.out.println("5 - Выйти из пользователя");
                    System.out.print("Ваш выбор: ");
                    switch (scanner.nextInt()) {
                        case 0:
                            return;
                        case 1:
                            System.out.print("Введите курс (RUB/EUR/USD): ");
                            String currency = scanner.next();
                            AccCodeType accCodeType = AccCodeType.valueOf(currency);
                            Account account = new Account(authorizedUser, BigDecimal.valueOf(0), accCodeType);
                            accountService.create(account);
                            System.out.println("Открыт новый аккаунт");
                            break;
                        case 2:
                            System.out.print("Введите UUID аккаунта: ");
                            UUID uuid = UUID.fromString(scanner.next());
                            System.out.print("Введите сумму для пополнения: ");
                            BigDecimal sum = scanner.nextBigDecimal();
                            if (sum.doubleValue() < 0) {
                                throw new IllegalArgumentException("Сумма пополнения должна быть положительная");
                            }
                            accountService.replenish(uuid, sum);
                            break;
                        case 3:
                            System.out.print("Введите UUID аккаунта, откуда хотите перевести средства: ");
                            UUID fromUUID = UUID.fromString(scanner.next());
                            Set<User> allUsers = userService.getAll();
                            System.out.println("Телефоны клиентов: ");
                            System.out.println("=============");
                            for (User curUser : allUsers) {
                                System.out.println(curUser.getPhone());
                                System.out.println("=============");
                            }
                            System.out.print("Введите номер телефона адресата: ");
                            String phone = scanner.next();
                            User user = userService.getUserByPhone(phone);
                            if (Objects.isNull(user)) {
                                throw new UserNotFoundException("Пользователь с таким телефоном не найден");
                            }
                            Set<Account> accounts = accountService.getAllByUserId(user.getId());
                            System.out.println("Доступные счета для перевода: ");
                            System.out.println("=============");
                            for (Account curAccount : accounts) {
                                System.out.println(curAccount);
                                System.out.println("=============");
                            }
                            System.out.print("Введите UUID счета для перевода: ");
                            UUID toUUID = UUID.fromString(scanner.next());
                            System.out.print("Введите сумму перевода: ");
                            sum = scanner.nextBigDecimal();
                            if (sum.doubleValue() < 0) {
                                throw new IllegalArgumentException("Сумма перевода должна быть положительная");
                            }
                            accountService.transfer(authorizedUser, fromUUID, toUUID, sum);
                            break;
                        case 4:
                            Set<Transfer> transfers = transferService.getAllByUser(authorizedUser);
                            System.out.println("=============");
                            for (Transfer transfer : transfers) {
                                System.out.print(transfer + " ");
                                System.out.println("=============");
                            }
                            System.out.println();
                            break;
                        case 5:
                            authorizedUser = null;
                            break;
                        default:
                            System.out.println("Неизвестная команда");
                            break;
                    }
                } else {
                    System.out.println("1 - регистрация");
                    System.out.println("2 - авторизация");
                    System.out.print("Ваш выбор: ");
                    switch (scanner.nextInt()) {
                        case 0:
                            return;
                        case 1:
                            System.out.print("Введите логин: ");
                            String login = scanner.next();
                            System.out.print("Введите пароль: ");
                            String password = scanner.next();
                            System.out.print("Введите телефон: ");
                            String phone = scanner.next();
                            System.out.print("Введите адрес: ");
                            String address = scanner.next();
                            User user = new User(login, password, address, phone);
                            userService.register(user);
                            System.out.println("Вы зарегистрировались");
                            break;
                        case 2:
                            System.out.print("Введите логин: ");
                            login = scanner.next();
                            System.out.print("Введите пароль: ");
                            password = scanner.next();
                            authorizedUser = userService.login(login, password);
                            break;
                        default:
                            System.out.println("Неизвестная команда");
                            break;
                    }
                }
            } catch (Exception ex) {
                error = ex.getMessage();
            }
        }
    }

}
