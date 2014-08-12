package com.fyodor.generators;

import com.google.common.collect.Range;

import java.util.Random;

public class RDG {

    static Random random = new Random();

    public static Generator<String> string = string(30);
    public static Generator<Integer> integer = integer(Integer.MAX_VALUE);

    public static Generator<String> string(Integer max) {
        return new StringGenerator(max);
    }

    public static Generator<String> string(Integer max, StringGenerator.CharSet charSet) {
        return new StringGenerator(max, charSet);
    }

    public static Generator<Integer> integer(Integer max) {
        return new IntegerGenerator(max);
    }

    public static Generator<Integer> integer(Range<Integer> range) {
        return new IntegerGenerator(range);
    }
}
