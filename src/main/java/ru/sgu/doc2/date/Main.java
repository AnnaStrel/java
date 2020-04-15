package ru.sgu.doc2.date;

public class Main {

    public static void main(String[] args) throws Exception {
        Date date = new Date(29, 11, 1997);
        System.out.println("Начальная дата: " + date);
        date.incDateByOneYear();
        System.out.println("Увеличили на год: " + date);
        date.incDateByOneMonth();
        System.out.println("Увеличили на месяц: " + date);
        date.incDateByOneMonth();
        System.out.println("Увеличили на месяц: " + date);
        date.decDateByTwoDays();
        System.out.println("Уменьшили на 2 дня: " + date);
        date.setDay(1);
        date.setMonth(3);
        date.decDateByTwoDays();
        System.out.println("Поставили на 01.03 и уменьшили на 2 дня: " + date);
        date.setDay(2);
        date.setMonth(1);
        date.decDateByTwoDays();
        System.out.println("Поставили на 01.01 и уменьшили на 2 дня: " + date);
        date.setDay(2);
        date.setMonth(2);
        System.out.println("Поставили на 02.02: " + date);
        System.out.println("Равны ли месяц и день: " + date.isDayAndMonthEquals());
    }

}
