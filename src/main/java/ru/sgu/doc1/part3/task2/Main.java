package ru.sgu.doc1.part3.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое A: ");
        int A = scanner.nextInt();
        System.out.print("Введите целое B: ");
        int B = scanner.nextInt();
        if (A >= B) {
            return;
        }
        int count = 0;
        for (int i = B - 1; i > A; i--) {
            System.out.print(i + " ");
            count++;
        }
        System.out.println();
        System.out.println("Количество целых чисел: " + count);
    }

}
