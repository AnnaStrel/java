package ru.sgu.doc2.time;

public class Time {

    private int hour;

    private int minute;

    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) throws Exception {
        if (hour < 0 || hour > 23) {
            throw new Exception("Неверное значение часа");
        }
        if (minute < 0 || minute > 59) {
            throw new Exception("Неверное значение минуты");
        }
        if (second < 0 || second > 59) {
            throw new Exception("Неверное значение секунды");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws Exception {
        if (hour < 0 || hour > 23) {
            throw new Exception("Неверное значение часа");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws Exception {
        if (minute < 0 || minute > 59) {
            throw new Exception("Неверное значение минуты");
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) throws Exception {
        if (second < 0 || second > 59) {
            throw new Exception("Неверное значение секунды");
        }
        this.second = second;
    }

    public int secondsCount() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    public void incTimeByFiveSeconds() {
        if (this.second < 55) {
            this.second += 5;
        } else {
            this.second = Math.abs(55 - this.second);
            if (this.minute == 59) {
                if (this.hour == 23) {
                    this.hour = 0;
                } else {
                    this.hour++;
                }
                this.minute = 0;
            } else {
                this.minute++;
            }
        }
    }

    @Override
    public String toString() {
        String hour = String.valueOf(this.hour);
        String minute = String.valueOf(this.minute);
        String second = String.valueOf(this.second);
        if (this.hour < 10) {
            hour = "0" + hour;
        }
        if (this.minute < 10) {
            minute = "0" + minute;
        }
        if (this.second < 10) {
            second = "0" + second;
        }
        return String.format("%s:%s:%s", hour, minute, second);
    }

}
