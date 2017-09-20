package com.equalexperts.fb;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicResultCalculatorTest {

    private ResultCalculator calculatorUnderTest = new BasicResultCalculator();

    private static int[] integerResults = {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19};
    private static int[] fizzResults = {3, 6, 9, 12, 18};
    private static int[] buzzResults = {5, 10, 20};
    private static int[] fizzBuzzResults = {15, 30,};

    @Test
    public void calculateInteger() {
        for (int integerResult : integerResults) {
            assertThat(calculatorUnderTest.calculateResult(integerResult)).isEqualTo(String.valueOf(integerResult));
        }
    }

    @Test
    public void calculateFizz() {
        for (int fizzResult : fizzResults) {
            assertThat(calculatorUnderTest.calculateResult(fizzResult)).isEqualTo("fizz");
        }
    }

    @Test
    public void calculateBuzz() {
        for (int buzzResult : buzzResults) {
            assertThat(calculatorUnderTest.calculateResult(buzzResult)).isEqualTo("buzz");
        }

    }

    @Test
    public void calculateFizzBuzz() {
        for (int fizzBuzzResult : fizzBuzzResults) {
            assertThat(calculatorUnderTest.calculateResult(fizzBuzzResult)).isEqualTo("fizzbuzz");
        }
    }

}