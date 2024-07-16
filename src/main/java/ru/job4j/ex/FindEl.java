package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                return result;
            }
        }
        throw new ElementNotFoundException("Element '" + key + "' not found.");
    }

    public static void main(String[] args) {
        String[] array = {"car", "plane", "boat"};
        String key = "plane";

        try {
            int index = indexOf(array, key);
            System.out.println("Index of '" + key + "': " + index);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}