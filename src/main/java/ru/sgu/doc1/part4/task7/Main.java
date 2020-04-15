package ru.sgu.doc1.part4.task7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int N = scanner.nextInt();
        String result;
        switch (N) {
            case 0:
                result = "Ноль";
                break;
            case 1:
                result = "Один";
                break;
            case 2:
                result = "Два";
                break;
            case 3:
                result = "Три";
                break;
            case 4:
                result = "Четыре";
                break;
            case 5:
                result = "Пять";
                break;
            case 6:
                result = "Шесть";
                break;
            case 7:
                result = "Семь";
                break;
            case 8:
                result = "Восемь";
                break;
            case 9:
                result = "Девять";
                break;
            default:
                result = "Число не в диапазоне [0, 9]";
                break;
        }
        System.out.println(result);
    }

}
