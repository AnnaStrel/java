package ru.sgu.doc1.part2.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное N: ");
        int N = scanner.nextInt();
        boolean flag = false;
        if (N % 2 == 0) {
            double temp = N;
            while (temp != 1 && temp % 2 == 0) {
                temp /= 2;
            }
            flag = temp == 1;
        }
        if (flag) {
            System.out.print("Является степенью двойки");
        } else {
            System.out.print("Не является степенью двойки");
        }
    }

}
