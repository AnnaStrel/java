package ru.sgu.doc1.part4.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean isLucky(int n) {
        boolean[] flags = new boolean[10];
        for (int i = 0; i < 10; i++) {
            flags[i] = false;
        }
        while (n > 0) {
            int digit = n % 10;
            if (flags[digit]) {
                return false;
            }
            flags[digit] = true;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int N = scanner.nextInt();
        List<Integer> array = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            System.out.print("Введите число: ");
            array.add(scanner.nextInt());
        }

        for (Integer x : array) {
            if (isLucky(x)) {
                System.out.print(x + " ");
            }
        }
    }

}
