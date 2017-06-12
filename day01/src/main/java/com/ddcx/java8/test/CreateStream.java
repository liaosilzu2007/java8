package com.ddcx.java8.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by liaosi on 2017/5/31.
 */
public class CreateStream {

    @Test
    public void test1() {

        //1.Collection
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        //2.Arrays
        Integer[] numbers = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(numbers);

        //3.Stream
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6);
        //stream3.forEach(System.out::println);

        //创建无限流，迭代和生成
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2).limit(10);
        //stream4.forEach(System.out::println);

        Stream<Double> stream5 = Stream.generate(Math::random).limit(5);
        stream5.forEach(System.out::println);

    }

}
