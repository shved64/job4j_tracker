package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("shved64@mail.ru", "Kravchuk Pavel Andreevich");
        map.put("shved6@mail.ru", "Tkachuk Pavel Andreevich");
        map.put("shved64@mail.ru", "Kravchuk Pavel Andreevich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
