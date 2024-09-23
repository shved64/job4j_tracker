package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element Not Found");
    }

    public static void main(String[] args) {
        try {
            int index = indexOf(new String[]{"Alice", "Bob", "Nik"}, "Bob");
            System.out.println("Bob " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
