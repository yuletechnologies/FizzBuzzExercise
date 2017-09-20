package com.equalexperts.fb;


public class LuckyNumberResultCalculator implements ResultCalculator {

    private final ResultCalculator fallbackResultCalculator;

    public LuckyNumberResultCalculator(ResultCalculator theFallbackResultCalculator) {
        if (theFallbackResultCalculator == null ) {
            throw new IllegalArgumentException("Invalid Fallback Result Calculator. Provide a not null Fallback Result Calculator.");
        }
        fallbackResultCalculator = theFallbackResultCalculator;
    }

    @Override
    public String calculateResult(int number) {
        return String.valueOf(number).contains("3") ? "lucky" : fallbackResultCalculator.calculateResult(number);
    }
}
