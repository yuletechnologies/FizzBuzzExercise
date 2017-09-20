package com.equalexperts.fb.reporting;

import com.equalexperts.fb.BasicResultCalculator;
import com.equalexperts.fb.FizzBuzzGame;
import com.equalexperts.fb.LuckyNumberResultCalculator;
import com.equalexperts.fb.ResultCalculator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzGameTestWithReporting {

    private ResultCalculator theFallbackResultCalculator;
    private LuckyNumberResultCalculator luckyNumberResultCalculator;
    private FizzBuzzGame fizzBuzzGameUnderTest;
    private FizzBuzzReporter fizzBuzzReporter;

    @Before
    public void setupObjects() {

        fizzBuzzReporter = new FizzBuzzReporter();
        theFallbackResultCalculator = new BasicResultCalculator();
        luckyNumberResultCalculator = new LuckyNumberResultCalculator(theFallbackResultCalculator);
        fizzBuzzGameUnderTest = new FizzBuzzGame(luckyNumberResultCalculator, fizzBuzzReporter);
    }

    @Test
    public void playGameProducesOutput() {
        String playResult = fizzBuzzGameUnderTest.play(1, 20);
        assertThat(playResult).isEqualTo("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10");
    }

    @Test
    public void playGameProducesOutputOtherRange() {
        String playResult = fizzBuzzGameUnderTest.play(20, 42);
        assertThat(playResult).isEqualTo("buzz fizz 22 lucky fizz buzz 26 fizz 28 29 lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky buzz 41 fizz fizz: 4 buzz: 3 fizzbuzz: 0 lucky: 11 integer: 5");
    }
    @Test
    public void playGameProducesOutputRangeOfOne() {
        String playResult = fizzBuzzGameUnderTest.play(20, 20);
        assertThat(playResult).isEqualTo("buzz fizz: 0 buzz: 1 fizzbuzz: 0 lucky: 0 integer: 0");
    }

    @Test
    public void playGameProducesOutputForNegativeRanges() {
        String playResult = fizzBuzzGameUnderTest.play(-20, 1);
        assertThat(playResult).isEqualTo("buzz -19 fizz -17 -16 fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 fizzbuzz 1 fizz: 4 buzz: 3 fizzbuzz: 2 lucky: 2 integer: 11");

        playResult = fizzBuzzGameUnderTest.play(-20,-1 );
        assertThat(playResult).isEqualTo("buzz -19 fizz -17 -16 fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 fizz: 8 buzz: 6 fizzbuzz: 3 lucky: 4 integer: 21");
    }


    @Test
    public void playGameProducesExceptionForInvertedRange() {
        Assertions.assertThatThrownBy(() -> fizzBuzzGameUnderTest.play(20, 1)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("Invalid Range. Provide a valid range of Integers.");
    }
}
