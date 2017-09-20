package com.equalexperts.fb;

import com.equalexperts.fb.reporting.FizzBuzzReporter;

import java.util.Optional;
import java.util.stream.IntStream;

public class FizzBuzzGame {


    private final ResultCalculator resultCalculator;
    private final Optional<FizzBuzzReporter> reporter;

    /**
     * Use new FizzBuzzGame(ResultCalculator) instead.
     * This constructor will be removed in version 2.0, assuming clients don't use the version's 1.0 functionality anymore
     */
    @Deprecated
    public FizzBuzzGame() {
        resultCalculator = new BasicResultCalculator();
        reporter = Optional.empty();
    }

    public FizzBuzzGame(ResultCalculator theResultCalculator) {
        verifyResultCalculator(theResultCalculator);
        resultCalculator = theResultCalculator;
        reporter = Optional.empty();
    }


    public FizzBuzzGame(ResultCalculator theResultCalculator, FizzBuzzReporter theReporter) {
        verifyResultCalculator(theResultCalculator);
        resultCalculator = theResultCalculator;
        reporter = Optional.ofNullable(theReporter);
    }

    public String play(int start, int end) {
        validateInput(start, end);
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(start, end + 1).forEach(number -> {
                    String result = resultCalculator.calculateResult(number);
                    if (reporter.isPresent()) {
                        reporter.get().collect(result);
                    }
                    stringBuilder.append(result).append(" ");
                }
        );
        String playResult = stringBuilder.toString().trim();
        return reporter.isPresent() ? reporter.get().appendReport(playResult) : playResult;
    }

    private void validateInput(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Invalid Range. Provide a valid range of Integers.");
        }
    }

    private void verifyResultCalculator(ResultCalculator theResultCalculator) {
        if (null == theResultCalculator) {
            throw new IllegalArgumentException("Invalid Result Calculator. Provide a not null Result Calculator.");
        }
    }



}
