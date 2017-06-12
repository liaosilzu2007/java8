package com.ddcx.java8.test;

import com.ddcx.java8.entity.Employee;
import com.ddcx.java8.entity.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liaosi on 2017/6/4.
 */
public class TestStreamAPI3 {


    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    //归约
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Double> op1 = emps.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op1.get());
    }

    //收集
    @Test
    public void test2() {
        List<String> nameList = emps.stream().map(Employee::getName).collect(Collectors.toList());
        nameList.forEach(System.out::println);

        System.out.println("----------------------");

        Set<String> nameSet = emps.stream().map(Employee::getName).collect(Collectors.toSet());
        nameSet.forEach(System.out::println);


        System.out.println("----------------------");

        HashSet<String> hashSet = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Long count = emps.stream().collect(Collectors.counting());
        System.out.println("总数：" + count);

        Double avgSalary = emps.stream().
                collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("平均工资" + avgSalary);

        Double sumSalary = emps.stream().
                collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sumSalary);

        Optional<Employee> op1 = emps.stream().
                collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println("工资最高：" + op1.get());

        Optional<Employee> op2 = emps.stream().
                collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println("年龄最小：" + op2.get());

    }


    //分组
    @Test
    public void test4() {
        Map<Status, List<Employee>> map1 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map1);

        Map<Status, Map<String, List<Employee>>> map2 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((emp) -> {
                    if (emp.getAge() <= 35) {
                        return "青年";
                    } else if (emp.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map2);

    }

    //分区
    @Test
    public void test5() {
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy((emp) -> emp.getSalary() > 6000));
        System.out.println(map);
    }

    //统计
    @Test
    public void test6() {
        DoubleSummaryStatistics salaryStatistics = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(salaryStatistics);
    }

    //连接
    @Test
    public void test7() {
        String collect = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test8() {
        //System.out.println("hello");
        System.out.println("world");
    }
}
