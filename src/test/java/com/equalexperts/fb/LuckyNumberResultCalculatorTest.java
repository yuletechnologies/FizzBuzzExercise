package com.equalexperts.fb;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LuckyNumberResultCalculatorTest {

    private static int[] luckyNumbers = {3, 13, 23, 33, 43, 302};
    private static int[] nonLuckyNumbers = {1, 2, 4, 5, 6, 7, 8, 9, 124, 212};

    private ResultCalculator mockedResultCalculator;
    private LuckyNumberResultCalculator calculatorUnderTest;


    @Before
    public void setupObjects() {
        mockedResultCalculator = mock(ResultCalculator.class);
        when(mockedResultCalculator.calculateResult(anyInt())).thenReturn("OTHER_RESULT");
        calculatorUnderTest = new LuckyNumberResultCalculator(mockedResultCalculator);
    }

    @Test
    public void requiresFallbackResultCalculator() {
        Assertions.assertThatThrownBy(() -> new LuckyNumberResultCalculator(null)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("Invalid Fallback Result Calculator. Provide a not null Fallback Result Calculator.");
    }
    @Test
    public void overrideLuckyNumber() {
        for (int luckyNumber : luckyNumbers) {
            assertThat(calculatorUnderTest.calculateResult(luckyNumber)).isEqualTo("lucky");
        }
    }

    @Test
    public void fallbackOnNonLuckyNumber() {
        for (int luckyNumber : nonLuckyNumbers) {
            calculatorUnderTest.calculateResult(luckyNumber);
            assertThat(calculatorUnderTest.calculateResult(luckyNumber)).isEqualTo("OTHER_RESULT");
        }

    }
}