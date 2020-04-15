package ru.sgu.doc1.part2.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int N = scanner.nextInt();
        for (int i = 5; i <= N; i += 5) {
            System.out.print(i + " ");
        }
    }

}
