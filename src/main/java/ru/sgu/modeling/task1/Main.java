//package ru.sgu.modeling.task1;
//import java.util.Random;
//import java.util.stream.Stream;
//public class Main {
//    private static float getRandomCoord(int lowerBound, int upperBound) {
//        Random random = new Random();
//        float R_sum = 0;
//        for (int i = lowerBound; i <= upperBound; i++) {
//            R_sum += random.nextFloat();
//        }
//        float u = 0;
//        float sigm = 8;
//        return u + sigm * (R_sum - 6);
//    }
//
//    public static void main(String[] args) {
//        float sum = 0;
//        for (int i = 0; i < 1000; i++) {
//            int goodShot = 0;
//            for (int j = 0; j < 2; j++) {
//                float X = getRandomCoord(1, 12);
//                float Y = getRandomCoord(12, 23);
//                if (Math.sqrt(Math. pow (X, 2.0) + Math. pow (Y, 2.0)) <= 10) {
//                    goodShot++;
//                }
//            }
//            if (goodShot > 0) {
//                sum++;
//            }
//        }
//        System.out.println("M: " + sum / 1000);
//    }
//}