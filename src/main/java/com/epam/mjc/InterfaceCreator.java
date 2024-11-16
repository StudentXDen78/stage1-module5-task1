package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String e : list) if (!Character.isUpperCase(e.charAt(0))) return false;
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
       return listNumbers -> {
            for (Integer number : listNumbers) {
                if (number % 2 == 0) listNumbers.add(number);
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String e : values) {
                if (Character.isUpperCase(e.charAt(0)) && e.endsWith(".") && Arrays.stream(e.split(" ")).toArray().length > 3) list.add(e);
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return map -> {
            Map<String, Integer> stringSize= new LinkedHashMap<>();
            for (String word : map) {
                stringSize.put(word, word.length());
            }
            return stringSize;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list1);
            newList.addAll(list2);
            return newList;
        };
    }
}
