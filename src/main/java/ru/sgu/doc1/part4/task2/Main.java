package ru.sgu.doc1.part4.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
            if (x % 3 == 0) {
                System.out.print(x + " ");
            }
        }
    }

}
