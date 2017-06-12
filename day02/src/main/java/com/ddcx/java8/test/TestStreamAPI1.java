package com.ddcx.java8.test;

import com.ddcx.java8.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by liaosi on 2017/6/4.
 */
public class TestStreamAPI1 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "a赵六", 8, 7777.77),
            new Employee(104, "c赵六", 8, 7777.77),
            new Employee(104, "b赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //映射

    @Test
    public void test1() {
        Stream<String> stream1 = emps.stream().map(Employee::getName);
        //stream1.forEach(System.out::println);

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        Stream<String> stream2 = strList.stream().map(String::toUpperCase);
        //stream2.forEach(System.out::println);

        Stream<Stream<Character>> stream3 = strList.stream().map(TestStreamAPI1::filterCharacter);
        stream3.forEach((stream) -> stream.forEach(System.out::println));

        System.out.println("------------------------");

        Stream<Character> stream4 = strList.stream().flatMap(TestStreamAPI1::filterCharacter);
        stream4.forEach(System.out::println);
    }

    private static Stream<Character> filterCharacter(String str) {
        List<Character> charList = new ArrayList<>();

        for (char c : str.toCharArray()) {
            charList.add(c);
        }

        return charList.stream();
    }

    //排序
    @Test
    public void test2() {
        emps.stream().map(Employee::getName).sorted().forEach(System.out::println);

        System.out.println("-----------------------");

        emps.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        }).forEach(System.out::println);
    }

}
