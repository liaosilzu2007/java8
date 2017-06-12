package com.ddcx.java8.exer;

/**
 * Created by liaosi on 2017/5/29.
 */
@FunctionalInterface
public interface MyFunction<T, R> {

    R getValue(T t1, T t2);
}
