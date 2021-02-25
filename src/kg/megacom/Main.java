package kg.megacom;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        System.out.println("Выполнение...");
        long resArrayList = getTimeMsOfInsert(new ArrayList());
        long resLinkedList = getTimeMsOfInsert(new LinkedList());
        System.out.println("Вставка 500000 элементов в начало списка для ArrayList: " + resArrayList + "мс");
        System.out.println("Вставка 500000 элементов в начало списка для LinkedList: " + resLinkedList + "мс");
        long resArrayCenter = centerArrayList();
        System.out.println("\nВставка в середину списка из 5_000_000 для ArrayList " + resArrayCenter + "мс");
        long resLinkedCenter = centerLinkedList();
        System.out.println("Вставка в середину списка из 5_000_000 для LinkedList " + resLinkedCenter + "мс");
        long resNewArray = newArrayList();
        System.out.println("\nзаполнение 10_000_000 элементов для ArrayList " + resNewArray + "мс");
        long resNewLinked = newLinkedList();
        System.out.println("заполнение 10_000_000 элементов для LinkedList " + resNewLinked + "мс");
        long resShuffleArray = shuffleArrayList();
        System.out.println("\nперемешивание 10_000_000 элементов для ArrayList " + resShuffleArray + "мс");
        long resShuffleLinked = shuffleArrayList();
        System.out.println("перемешивание 10_000_000 элементов для LinkedList " + resShuffleLinked + "мс");
        long totalRes = resArrayList + resArrayCenter + resNewArray + resShuffleArray - resLinkedList - resLinkedCenter - resNewLinked - resShuffleLinked;
        System.out.println("\n\nразность времени выполнения 4 заданий между ArrayList  и LinkedList: " + totalRes + "мс");

    }

    public static long getTimeMsOfInsert(List list) {
        //напишите тут ваш код
        Date currentTime = new Date();
        insert1000000(list);
        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        return msDelay;
    }

    public static void insert1000000(List list) {
        for (int i = 0; i < 500000; i++) {
            list.add(0, new Object());
        }
    }

    public static long centerLinkedList() {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 5_000_000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list.add(2_000_000, Integer.MAX_VALUE);
        }
        return System.currentTimeMillis() - start;
    }

    public static long centerArrayList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5_000_000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list.add(2_000_000, Integer.MAX_VALUE);
        }
        return System.currentTimeMillis() - start;
    }

    public static long newArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        Collections.fill(list, Integer.MAX_VALUE);
        return System.currentTimeMillis() - start;
    }

    public static long newLinkedList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        Collections.fill(list, Integer.MAX_VALUE);
        return System.currentTimeMillis() - start;
    }


    public static long shuffleArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        Collections.fill(list, Integer.MAX_VALUE);
        long start = System.currentTimeMillis();
        Collections.shuffle(list);
        return System.currentTimeMillis() - start;
    }

    public static long shuffleLinkedList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        Collections.fill(list, Integer.MAX_VALUE);
        long start = System.currentTimeMillis();
        Collections.shuffle(list);
        return System.currentTimeMillis() - start;
    }


}
