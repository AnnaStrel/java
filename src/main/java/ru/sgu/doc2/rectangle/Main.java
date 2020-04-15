package ru.sgu.doc2.rectangle;

public class Main {

    public static void main(String[] args) throws Exception {
        Rectangle rectangle = new Rectangle(0, 2, 5, 8);
        System.out.println(rectangle);
        System.out.println("Площадь прямоугольника: " + rectangle.getSquare());
        System.out.println("Является ли квадратом: " + rectangle.isSquared());
        rectangle.setX2(2);
        rectangle.setY2(0);
        System.out.println(rectangle);
        System.out.println("Является ли квадратом: " + rectangle.isSquared());
        System.out.println("Площадь прямоугольника: " + rectangle.getSquare());
    }

}
