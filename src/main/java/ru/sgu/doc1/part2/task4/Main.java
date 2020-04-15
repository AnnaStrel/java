package ru.sgu.doc1.part2.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное N: ");
        int N = scanner.nextInt();
        int fab = 1, prev = 0;
        while (fab < N) {
            System.out.print(fab + " ");
            int temp = prev;
            prev = fab;
            fab += temp;
        }
    }

}
