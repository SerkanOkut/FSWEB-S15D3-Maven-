package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> inputList) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();
        for (Employee e : inputList) {
            if (e != null && !seen.add(e)) {
                if (!duplicates.contains(e)) {
                    duplicates.add(e);
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> inputList) {
        Map<Integer, Employee> result = new HashMap<>();
        Set<Integer> seenIds = new HashSet<>();
        for (Employee e : inputList) {
            if (e != null && !seenIds.contains(e.getId())) {
                seenIds.add(e.getId());
                result.put(e.getId(), e);
            }
        }
        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> inputList) {
        Map<Employee, Integer> countMap = new HashMap<>();
        for (Employee e : inputList) {
            if (e != null) {
                countMap.put(e, countMap.getOrDefault(e, 0) + 1);
            }
        }
        List<Employee> result = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
