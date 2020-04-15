package ru.sgu.doc1.part2.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int N = scanner.nextInt();
        for (int i = 3; i <= N; i += 3) {
            if (i % 5 != 0) {
                int temp = i, sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                if (sum % 5 != 0 && sum % 3 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }

}
