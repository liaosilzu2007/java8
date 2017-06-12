package com.ddcx.java8.exer;

import com.ddcx.java8.bean.Employee;
import com.sun.javafx.image.IntToIntPixelConverter;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liaosi on 2017/5/29.
 */
public class LambdaExer {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void exer1() {
        Collections.sort(emps, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void exer2() {
        StringFunction sf = (s) -> s.toUpperCase();
        System.out.println(sf.getValue("hello world!"));

        sf = (s) -> s.substring(2, 4);
        System.out.println(sf.getValue("abcdefg"));
    }

    @Test
    public void exer2_1() {
        String str1 = strHandler("hello world!", (str) -> str.toUpperCase());
        System.out.println(str1);

        String str2 = strHandler("abcdefg", (str) -> str.substring(2, 4));
        System.out.println(str2);
    }

    public String strHandler(String str, StringFunction sf) {
        return sf.getValue(str);
    }

    @Test
    public void exer3() {
        Long v1 = operateLong(100L, 200L, (l1, l2) -> l1 + l2);
        System.out.println(v1);

        Long v2 = operateLong(100L, 200L, (l1, l2) -> l1 * l2);
        System.err.println(v2);
    }

    public Long operateLong(Long l1, Long l2, MyFunction<Long, Long> mf) {
        return mf.getValue(l1, l2);
    }


}
