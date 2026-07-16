package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> filteredList = list.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        System.out.println(filteredList);
     }
}
