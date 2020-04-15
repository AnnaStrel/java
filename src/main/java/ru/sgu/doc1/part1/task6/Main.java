package ru.sgu.doc1.part1.task6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.print("Введите число от 1 до 12: ");
        x = scanner.nextInt();
        if (x == 12 || (x >= 1 && x <= 2)) {
            System.out.println("Зима");
        } else if (x >= 3 && x <= 5) {
            System.out.println("Весна");
        } else if (x >= 6 && x <= 8) {
            System.out.println("Лето");
        } else if (x >= 9 && x <= 11) {
            System.out.println("Осень");
        } else {
            System.out.println("Некорректный номер месяца");
        }
    }

}
