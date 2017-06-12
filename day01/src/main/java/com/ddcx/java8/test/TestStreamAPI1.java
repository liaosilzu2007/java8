package com.ddcx.java8.test;

import com.ddcx.java8.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liaosi on 2017/6/1.
 */
public class TestStreamAPI1 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55),
            new Employee(105, "田七", 38, 5555.55)
    );

    //过滤和切片

    @Test
    public void testFilter() {
        emps.stream().filter((emp) -> {
            System.out.println("stream的过滤器");
            return emp.getAge() > 30;
        }).forEach(System.out::println);

        System.out.println("-----------------------------------");

        List<String> collect = emps.stream().filter((emp) -> emp.getAge() > 60)
                .map((emp) -> emp.getName())
                .collect(Collectors.toList());
        //System.out.println(collect);
        collect.forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        emps.stream().limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        emps.stream().skip(4)
                .forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        emps.stream().distinct()
                .forEach(System.out::println);
    }
}
