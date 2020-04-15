package ru.sgu.doc1.part3.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите вещественное A: ");
        double A = scanner.nextDouble();
        System.out.print("Введите целое N: ");
        int N = scanner.nextInt();
        if (N < 1) {
            return;
        }
        double result = 1;
        for (int i = 1; i < N; i++) {
            result *= A;
        }
        System.out.println(String.format("%f в степени %d = %f", A, N, result));
    }

}
