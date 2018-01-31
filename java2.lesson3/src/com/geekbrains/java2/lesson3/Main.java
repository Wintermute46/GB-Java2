package com.geekbrains.java2.lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Задание 1.
        List<String> words = new ArrayList<>();

        words.add("перешеек");
        words.add("десятигранный");
        words.add("клешня");
        words.add("нечто");
        words.add("вырезка");
        words.add("клешня");
        words.add("семнадцать");
        words.add("примус");
        words.add("чарльстон");
        words.add("виброзонд");
        words.add("люминограф");
        words.add("нечто");
        words.add("примус");
        words.add("чарльстон");
        words.add("нечто");

        Set<String> uniqWords = new HashSet<>();
        Map<String, Integer> countWords = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            uniqWords.add(words.get(i));
            if (!countWords.containsKey(words.get(i)))
                countWords.put(words.get(i), 1);
            else
                countWords.put(words.get(i), countWords.get(words.get(i)) + 1);
        }

        System.out.println("Задание 1.\nИсходный массив:");
        System.out.println(words);
        System.out.println("Уникальные значения:");
        System.out.println(uniqWords);
        System.out.println("Количество совпадений:");
        System.out.println(countWords);

        //Задание 2.
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("+7(123)456-78-90", "Иванов");
        phoneBook.add("+7(123)456-78-91", "Петров");
        phoneBook.add("+7(123)456-78-92", "Сидоров");
        phoneBook.add("+7(123)456-78-93", "Ивановский");
        phoneBook.add("+7(123)456-78-94", "Петровский");
        phoneBook.add("+7(123)456-78-95", "Сидоровский");
        phoneBook.add("+7(123)456-78-96", "Иванидзе");
        phoneBook.add("+7(123)456-78-97", "Петридзе");
        phoneBook.add("+7(123)456-78-98", "Сидоридзе");
        phoneBook.add("+7(123)456-78-99", "Иванов");

        System.out.println("\nЗадание 2.");
        phoneBook.get("Иванов");
    }
}
