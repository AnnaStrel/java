package ru.sgu.doc2.date;

public class Date {

    private int[] daysCount = {30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int day;

    private int month;

    private int year;

    public Date() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }

    public Date(int day, int month, int year) throws Exception {
        if (month < 1 || month > 12) {
            throw new Exception("Неверное значение месяца");
        }
        daysCount[1] = isLeapYear(year) ? 29 : 28;
        if (day < 1 || day > daysCount[month - 1]) {
            throw new Exception("Неверное значение дня");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws Exception {
        daysCount[1] = isLeapYear(this.year) ? 29 : 28;
        if (day < 1 || day > daysCount[this.month - 1]) {
            throw new Exception("Неверное значение дня");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws Exception {
        if (month < 1 || month > 12) {
            throw new Exception("Неверное значение месяца");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void incDateByOneYear() {
        this.year++;
    }

    public void decDateByTwoDays() {
        if (this.day > 2) {
            this.day -= 2;
        } else {
            int temp;
            switch (this.month) {
                case 1:
                    temp = Math.abs(this.day - 2);
                    this.year--;
                    this.month = 12;
                    this.day = daysCount[11] - temp;
                    break;
                case 2:
                    temp = Math.abs(this.day - 2);
                    this.month--;
                    daysCount[1] = isLeapYear(this.year) ? 29 : 28;
                    this.day = daysCount[1] - temp;
                    break;
                default:
                    temp = Math.abs(this.day - 2);
                    this.month--;
                    this.day = daysCount[month - 1] - temp;
                    break;
            }
        }
    }

    public boolean isDayAndMonthEquals() {
        return this.day == this.month;
    }

    public void incDateByOneMonth() {
        if (this.month == 12) {
            this.month = 1;
            incDateByOneYear();
        } else {
            this.month++;
        }
    }

    @Override
    public String toString() {
        String day = String.valueOf(this.day);
        String month = String.valueOf(this.month);
        if (this.day < 10) {
            day = "0" + day;
        }
        if (this.month < 10) {
            month = "0" + month;
        }
        return String.format("%s.%s.%d", day, month, this.year);
    }

}
