package com.ddcx.java8.test;

import com.ddcx.java8.entity.Employee;
import com.ddcx.java8.entity.Employee.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by liaosi on 2017/6/4.
 */
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    //匹配
    @Test
    public void test1() {
        boolean b1 = emps.stream().allMatch((emp) -> Status.VOCATION.equals(emp.getStatus()));
        System.out.println("allMatch---->" + b1);

        boolean b2 = emps.stream().anyMatch((emp) -> Status.VOCATION.equals(emp.getStatus()));
        System.out.println("anyMatch---->" + b2);

        boolean b3 = emps.stream().noneMatch((emp) -> Status.VOCATION.equals(emp.getStatus()));
        System.out.println("noneMatch---->" + b2);

        Optional<Employee> first = emps.stream().skip(2).findFirst();
        System.out.println(first.get());

        long count = emps.stream().count();
        System.out.println(count);

        Optional<Double> op1 = emps.stream().map(Employee::getSalary).max(Double::compareTo);
        System.out.println(op1.get());

        Optional<Integer> op2 = emps.stream().map(Employee::getAge).min(Integer::compareTo);
        System.out.println(op2.get());
    }
}
