package ru.sgu.doc1.part1.task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        System.out.print("Введите первое число: ");
        a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        b = scanner.nextInt();
        System.out.print("Введите третье число: ");
        c = scanner.nextInt();
        a = a > 0 ? (int) Math.pow(a, 2) : a;
        b = b > 0 ? (int) Math.pow(b, 2) : b;
        c = c > 0 ? (int) Math.pow(c, 2) : c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
