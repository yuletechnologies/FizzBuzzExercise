package com.equalexperts.fb;

import java.util.stream.IntStream;

public class FizzBuzzGame {

    public String play(int start, int end) {
        validateInput(start,end);
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(start, end+1).forEach(number ->
            stringBuilder.append(getResult(number)).append(" ")
        );
        return stringBuilder.toString().trim();
    }

    private void validateInput(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Invalid Range. Provide a positive range of Integers.");
        }
    }

    private String getResult(int number) {

        String result = String.valueOf(number);

        result = number % 3 == 0 ? "fizz" : result ;
        result = number % 5 == 0 ? "buzz" : result ;
        result = number % 15 == 0 ? "fizzbuzz" : result ;
        return result;
    }
}
