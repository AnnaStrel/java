package ru.sgu.doc2.book;

public class Main {

    public static void main(String[] args) throws Exception {
        Book book = new Book("Книга 1", 100, 5000, 2015);
        System.out.println(book);
        System.out.println("Средняя стоимость одной страницы: " + book.getPagePrice());
        System.out.println("Прошло дней с момента издания: " + book.getPassedDaysCount());
    }

}
