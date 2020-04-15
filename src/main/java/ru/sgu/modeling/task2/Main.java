//package ru.sgu.modeling.task2;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//public class Main {
//    private static Random random ;
//    private static double fun(double a, double b) {
//        return a * b;
//    }
//    private static double getNextRandom() {
//        return -0.5d * Math. log ( random .nextDouble());
//    }
//    public static void main(String[] args) {
//        random = new Random();
//        List<Double> result = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            double A = getNextRandom ();
//            double B = getNextRandom ();
//            double Z = fun (A, B);
//            result.add(Z);
//        }
//        double M = result.stream()
//                .mapToDouble(Double::doubleValue)
//                .sum();
//        System. out .println("M: " + M / result.size());
//        double disp = result.stream()
//                .mapToDouble(x -> Math. pow ((x - M / result.size()), 2.0)).sum();
//        System. out .println("SD: " + Math.sqrt(disp / result.size()));
//    }
//}