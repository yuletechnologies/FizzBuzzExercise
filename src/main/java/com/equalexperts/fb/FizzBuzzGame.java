package com.equalexperts.fb;

import java.util.stream.IntStream;

public class FizzBuzzGame {


    private final ResultCalculator resultCalculator;

    /**
     * Use new BuzzFizzGame(ResultCalculator) instead.
     * This constructor will be removed in version 2.0, assuming clients don't use the version's 1.0 functionality anymore
     */
    @Deprecated
    public FizzBuzzGame() {
        resultCalculator = new BasicResultCalculator();
    }

    public FizzBuzzGame(ResultCalculator theResultCalculator) {
        if (null == theResultCalculator) {
            throw new IllegalArgumentException("Invalid Result Calculator. Provide a not null Result Calculator.");
        }
        resultCalculator = theResultCalculator;
    }

    public String play(int start, int end) {
        validateInput(start,end);
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(start, end+1).forEach(number ->
                stringBuilder.append(resultCalculator.calculateResult(number)).append(" ")
        );
        return stringBuilder.toString().trim();
    }

    private void validateInput(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Invalid Range. Provide a valid range of Integers.");
        }
    }

}
