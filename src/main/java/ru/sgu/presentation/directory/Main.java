package ru.sgu.presentation.directory;

import java.util.Scanner;

public class Main {

    private static UserService userService = new UserService();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в консольное приложение по управлению абонентами!");
        while (true) {
            System.out.println("0 - выйти из приложения");
            System.out.println("1 - просмотреть абонентов");
            System.out.println("2 - добавить абонента");
            System.out.println("3 - обновить абонента");
            System.out.println("4 - удалить абнента");
            int n = scanner.nextInt();
            switch (n) {
                case 0:
                    return;
                case 1:
                    for (User user : userService.getAllUsers()) {
                        System.out.println(user);
                    }
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    String name = scanner.next();
                    System.out.print("Введите телефон: ");
                    String phone = scanner.next();
                    System.out.print("Введите возраст: ");
                    int age = scanner.nextInt();
                    User user = new User(name, phone, age);
                    userService.addUser(user);
                    System.out.println("Пользователь добавлен");
                    break;
                case 3:
                    System.out.print("Введите ID: ");
                    int id = scanner.nextInt();
                    if (!userService.existUser(id)) {
                        System.out.println("Абонента с указаннм ID не существует");
                        break;
                    }
                    System.out.print("Введите имя: ");
                    name = scanner.next();
                    System.out.print("Введите телефон: ");
                    phone = scanner.next();
                    System.out.print("Введите возраст: ");
                    age = scanner.nextInt();
                    user = new User(name, phone, age);
                    userService.updateUser(id, user);
                    System.out.println("Пользователь обновлен");
                    break;
                case 4:
                    System.out.print("Введите ID: ");
                    id = scanner.nextInt();
                    if (!userService.existUser(id)) {
                        System.out.println("Абонента с указаннм ID не существует");
                        break;
                    }
                    userService.deleteUserById(id);
                    System.out.println("Пользователь удален");
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }

}
