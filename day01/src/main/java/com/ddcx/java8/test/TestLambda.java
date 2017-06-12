package com.ddcx.java8.test;

import org.junit.Test;

/**
 * Created by liaosi on 2017/5/28.
 */
public class TestLambda {

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        r.run();
        System.err.println("-------------------------------");

        Runnable r1 = () -> System.out.println("hello lambda!");
        r1.run();
    }
}
