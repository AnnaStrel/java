package ru.sgu.doc2.employee;

public class Main {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee("Иванов", 50000, 2005);
        System.out.println(employee);
        System.out.println("Стаж работника: " + employee.getExperience() + " лет");
        System.out.println("Прошло дней после года поступления на работу: " + employee.getPassedDaysCount());
    }

}
