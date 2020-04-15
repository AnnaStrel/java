package ru.sgu.doc1.part4.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
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

        // НОД
        int gcd = array.get(0);
        for (int i = 0; i < array.size() - 1; i++) {
            gcd = gcd(Math.max(gcd, array.get(i + 1)), Math.min(gcd, array.get(i + 1)));
        }

        // НОК
        int lcm = array.get(0);
        for (int i = 0; i < array.size() - 1; i++) {
            lcm = lcm(Math.max(lcm, array.get(i + 1)), Math.min(lcm, array.get(i + 1)));
        }

        System.out.println("НОД = " + gcd);
        System.out.println("НОК = " + lcm);
    }

}
