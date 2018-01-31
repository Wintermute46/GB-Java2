package com.geekbrains.java2.lesson3;

import java.util.*;

public class PhoneBook {
    private Map<String, String> phones = new HashMap<>();

    public void add(String phone, String name) {
        this.phones.put(phone, name);
    }

    public void get(String name) {
        if (this.phones.containsValue(name)) {
            Iterator map = this.phones.entrySet().iterator();
            while (map.hasNext()) {
                Map.Entry entry = (Map.Entry) map.next();
                if (entry.getValue().equals(name))
                    System.out.println(entry);
            }
        } else System.out.println("Ничего не найдено!");
    }
}
