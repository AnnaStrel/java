package ru.sgu.doc1.part1.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите зарплату: ");
        int salary = scanner.nextInt();
        System.out.print("Введите стаж: ");
        int experience = scanner.nextInt();
        double surchargeCoef;
        int paySum;
        if (experience < 2) {
            surchargeCoef = 1;
        } else if (experience < 5) {
            surchargeCoef = 1.02;
        } else if (experience < 10) {
            surchargeCoef = 1.05;
        } else {
            return;
        }
        paySum = (int) (salary * surchargeCoef);
        System.out.println("Надбавка в процентах: " + (int) ((surchargeCoef - 1) * 100));
        System.out.println("Сумма выплаты: " + paySum);
    }

}
