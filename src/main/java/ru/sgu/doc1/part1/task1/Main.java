package ru.sgu.doc1.part1.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int numberOne = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int numberTwo = scanner.nextInt();
        double squaresSum = Math.pow(numberOne, 2) + Math.pow(numberTwo, 2);
        double sumsSquare = Math.pow(numberOne + numberTwo, 2);
        if (squaresSum > sumsSquare) {
            System.out.println("Сумма квадратов больше");
        } else if (squaresSum < sumsSquare) {
            System.out.println("Квадрат суммы больше");
        } else {
            System.out.println("Сумма квадратов равна квадрату суммы");
        }
    }

}
