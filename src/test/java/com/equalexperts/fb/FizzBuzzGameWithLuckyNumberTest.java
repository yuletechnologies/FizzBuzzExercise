package com.equalexperts.fb;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzGameWithLuckyNumberTest {

    private ResultCalculator theFallbackResultCalculator;
    private LuckyNumberResultCalculator luckyNumberResultCalculator;
    private FizzBuzzGame buzzFizzGameUnderTest;

    @Before
    public void setupObjects() {

        theFallbackResultCalculator = new BasicResultCalculator();
        luckyNumberResultCalculator = new LuckyNumberResultCalculator(theFallbackResultCalculator);
        buzzFizzGameUnderTest = new FizzBuzzGame(luckyNumberResultCalculator);
    }

    @Test
    public void requiresResultCalculator() {
        Assertions.assertThatThrownBy(() -> new FizzBuzzGame(null)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("Invalid Result Calculator. Provide a not null Result Calculator.");
    }
    @Test
    public void playGameProducesOutput() {
        String playResult = buzzFizzGameUnderTest.play(1, 20);
        assertThat(playResult).isEqualTo("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz");
    }

    @Test
    public void playGameProducesOutputOtherRange() {
        String playResult = buzzFizzGameUnderTest.play(20, 42);
        assertThat(playResult).isEqualTo("buzz fizz 22 lucky fizz buzz 26 fizz 28 29 lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky buzz 41 fizz");
    }
    @Test
    public void playGameProducesOutputRangeOfOne() {
        String playResult = buzzFizzGameUnderTest.play(20, 20);
        assertThat(playResult).isEqualTo("buzz");
    }

    @Test
    public void playGameProducesOutputForNegativeRanges() {
        String playResult = buzzFizzGameUnderTest.play(-20, 1);
        assertThat(playResult).isEqualTo("buzz -19 fizz -17 -16 fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 fizzbuzz 1");

        playResult = buzzFizzGameUnderTest.play(-20,-1 );
        assertThat(playResult).isEqualTo("buzz -19 fizz -17 -16 fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1");
    }


    @Test
    public void playGameProducesExceptionForInvertedRange() {
        Assertions.assertThatThrownBy(() -> buzzFizzGameUnderTest.play(20, 1)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("Invalid Range. Provide a valid range of Integers.");
    }

}