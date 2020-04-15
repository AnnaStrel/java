package ru.sgu.doc1.part1.task3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x0, y0, x1, y1;
        System.out.print("Введите x0: ");
        x0 = scanner.nextInt();
        System.out.print("Введите y0: ");
        y0 = scanner.nextInt();
        System.out.print("Введите x1: ");
        x1 = scanner.nextInt();
        System.out.print("Введите y1: ");
        y1 = scanner.nextInt();
        double dist1 = Math.sqrt((Math.pow(x0, 2) + Math.pow(y0, 2)));
        double dist2 = Math.sqrt((Math.pow(x1, 2) + Math.pow(y1, 2)));
        if (dist1 > dist2) {
            System.out.println("Точка A(x0, y0) наиболее удалена");
        } else if (dist1 < dist2) {
            System.out.println("Точка B(x1, y1) наиболее удалена");
        } else {
            System.out.println("Точки удалены одинаково");
        }
    }

}
