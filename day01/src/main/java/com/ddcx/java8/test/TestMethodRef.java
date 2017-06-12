package com.ddcx.java8.test;

import com.ddcx.java8.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * Created by liaosi on 2017/5/29.
 */
public class TestMethodRef {

    @Test
    public void test8() {
        Function<Integer, String[]> function = (size) -> new String[size];
        String[] strArr = function.apply(10);
        System.out.println(strArr.length);

        System.out.println("-----------------------");
        Function<Integer, String[]> function1 = String[]::new;
        String[] strArr2 = function1.apply(15);
        System.out.println(strArr2.length);

    }

    @Test
    public void test7() {
        Function<Integer, Employee> function = (age) -> new Employee(age);
        System.out.println(function.apply(30));

        System.out.println("-----------------------");
        Function<Integer, Employee> function1 = Employee::new;
        System.out.println(function1.apply(40));
    }

    @Test
    public void test6() {
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());

        System.out.println("-------------------");
        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());

    }

    @Test
    public void test5() {
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        System.out.println(biPredicate.test("ab", "ab"));

        System.out.println("-----------------------------------------");

        BiPredicate<String, String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("ab", "ac"));

        Employee emp = new Employee(101, "张三", 18, 9999.99);
        Function<Employee, String> function = (e) -> e.toString();
        System.out.println(function.apply(emp));

        System.out.println("******************************************");
        Function<Employee, String> function1 = Employee::toString;
        System.out.println(function1.apply(emp));

    }

    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(23, 17));

        System.out.println("--------------------------------------");

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator.compare(23, 17));
    }

    @Test
    public void test3() {
        BiFunction<Double, Double, Double> biFunction = (d1, d2) -> Math.max(d1, d2);
        System.out.println(biFunction.apply(25.4, 54.5));

        System.out.println("------------------------------------");

        BiFunction<Double, Double, Double> biFunction1 = Math::max;
        System.out.println(biFunction.apply(25.4, 54.5));
    }

    @Test
    public void test2() {
        Employee emp = new Employee(101, "张三", 18, 9999.99);

        Supplier<String> supplier = () -> emp.getName();
        System.out.println(supplier.get());

        System.out.println("-------------------------------------");

        Supplier<String> supplier1 = emp::getName;
        System.out.println(supplier1.get());

    }

    @Test
    public void test1() {

        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("hello world!");

        System.out.println("-------------------------------------");

        PrintStream out = System.out;
        Consumer<String> consumer1 = out::println;
        consumer1.accept("hello beijing!");

    }
}
