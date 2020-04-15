package ru.sgu.doc2.book;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Book {

    private String name;

    private int pagesCount;

    private int price;

    private int publishYear;

    public Book() {
        this.name = "";
        this.pagesCount = 0;
        this.price = 0;
        this.publishYear = 1970;
    }

    public Book(String name, int pagesCount, int price, int publishYear) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.price = price;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPagePrice() {
        return price / pagesCount;
    }

    public long getPassedDaysCount() {
        Calendar nowCalendar = Calendar.getInstance();
        Calendar publishYearCalendar = Calendar.getInstance();
        nowCalendar.setTime(new Date());
        publishYearCalendar.set(publishYear + 1, Calendar.JANUARY, 1);
        long difference = Duration.between(publishYearCalendar.toInstant(), nowCalendar.toInstant()).toDays();
        return difference > 0 ? difference : 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Название: %s\nКол-во страниц: %d\nЦена: %d\nГод издания: %d",
                this.name,
                this.pagesCount,
                this.price,
                this.publishYear
        );
    }

}
