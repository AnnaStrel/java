package ru.sgu.doc1.part1.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        System.out.print("Введите A: ");
        a = scanner.nextInt();
        System.out.print("Введите B: ");
        b = scanner.nextInt();
        System.out.print("Введите C: ");
        c = scanner.nextInt();
        boolean isRectangular = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
        if (isRectangular) {
            System.out.println("Треугольник является прямоугольным");
        } else {
            System.out.println("Треугольник не является прямоугольным");
        }
    }

}
