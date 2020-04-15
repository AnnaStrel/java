package ru.sgu.doc2.employee;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Employee {

    private String name;

    private int salary;

    private int employmentYear;

    public Employee() {
        this.name = "";
        this.salary = 0;
        this.employmentYear = 1970;
    }

    public Employee(String name, int salary, int employmentYear) {
        this.name = name;
        this.salary = salary;
        this.employmentYear = employmentYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    public long getExperience() {
        Calendar nowCalendar = Calendar.getInstance();
        Calendar employmentCalendar = Calendar.getInstance();
        nowCalendar.setTime(new Date());
        employmentCalendar.set(employmentYear, Calendar.JANUARY, 1);
        long difference = Duration.between(employmentCalendar.toInstant(), nowCalendar.toInstant()).toDays() / 365;
        return difference > 0 ? difference : 0;
    }

    public long getPassedDaysCount() {
        Calendar nowCalendar = Calendar.getInstance();
        Calendar employmentCalendar = Calendar.getInstance();
        nowCalendar.setTime(new Date());
        employmentCalendar.set(employmentYear + 1, Calendar.JANUARY, 1);
        long difference = Duration.between(employmentCalendar.toInstant(), nowCalendar.toInstant()).toDays();
        return difference > 0 ? difference : 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Фамилия: %s\nОклад: %d\nГод поступления на работу: %d",
                this.name,
                this.salary,
                this.employmentYear
        );
    }

}