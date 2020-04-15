package ru.sgu.presentation.collections;

import java.util.*;

public class Main {

    private static void printArray(List<Integer> array) {
        for (Integer x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void printMap(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(String.format("[%s] => %d", key, map.get(key)));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Random random = new Random();

        // 1
        System.out.println("======Сортировка ArrayList в порядке убывания");
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array.add(random.nextInt(10));
        }

        printArray(array);
        array.sort(Collections.reverseOrder());
        printArray(array);

        // 2
        System.out.println("=====Сумма элементов массива");
        printArray(array);
        System.out.println("Сумма = " + array.stream().mapToInt(x -> x).sum());

        // 3
        System.out.println("=====Проверка содержит ли Map заданное значение или нет");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            map.put(uuid, random.nextInt(10));
        }
        printMap(map);
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Карта содержит число %d - %s", i, map.containsValue(i)));
        }

        // 4
        System.out.println("=====Вставка элементов в начало и конец LinkedList ");
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        printArray(list);
        list.addFirst(99);
        list.addLast(101);
        printArray(list);

        // 5
        System.out.println("=====Поиск элемента в ArrayList ");
        printArray(array);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(String.format("Элемент %d находится в %d-ой позиции", i, array.indexOf(i)));
        }
    }

}
