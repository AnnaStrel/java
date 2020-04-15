package ru.sgu.doc2.time;

public class Main {

    public static void main(String[] args) throws Exception {
        Time time = new Time(5, 16, 58);
        System.out.println("Начально время: " + time);
        time.incTimeByFiveSeconds();
        System.out.println("Увеличили на 5 секунд: " + time);
        System.out.println("Количество секунд: " + time.secondsCount());
        time.setHour(23);
        time.setMinute(59);
        time.setSecond(56);
        System.out.println("Поставили на 23:59:55: " + time);
        time.incTimeByFiveSeconds();
        System.out.println("Увеличили на 5 секунд: " + time);
        System.out.println("Количество секунд: " + time.secondsCount());
    }

}
