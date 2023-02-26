// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, которая найдет и выведет 
// повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        String employees = "Иван " +
                "Светлана " +
                "Кристина " +
                "Анна " +
                "Анна " +
                "Иван " +
                "Петр " +
                "Павел " +
                "Петр " +
                "Мария" ;

        String[] listOfNamesAndSurnames = employees.split(" ");
        for (int i = 0; i < listOfNamesAndSurnames.length; i += 2) {
            if (nameMap.containsKey(listOfNamesAndSurnames[i])) {
                nameMap.replace(listOfNamesAndSurnames[i], nameMap.get(listOfNamesAndSurnames[i]) + 1);
            } else {
                nameMap.put(listOfNamesAndSurnames[i], 1);
            }
        }
        System.out.println(nameMap);
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println(sortedNameMap);
    }
}