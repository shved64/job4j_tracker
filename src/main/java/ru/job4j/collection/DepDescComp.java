package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = right.split("/")[0].compareTo(left.split("/")[0]);
        if (result == 0) {
            result = left.compareTo(right);
        }
        return result;
    }
}
