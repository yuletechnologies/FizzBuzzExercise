package com.equalexperts.fb;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FizzBuzzGameTest {


    private FizzBuzzGame fizzBuzzGameUnderTest = new FizzBuzzGame();

    @Test
    public void playGameProducesOutput() {

        String playResult = fizzBuzzGameUnderTest.play(1, 20);
        Assertions.assertThat(playResult).isEqualTo("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz");
    }

    @Test
    public void playGameProducesOutputOtherRange() {
        String playResult = fizzBuzzGameUnderTest.play(20, 42);
        Assertions.assertThat(playResult).isEqualTo("buzz fizz 22 23 fizz buzz 26 fizz 28 29 fizzbuzz 31 32 fizz 34 buzz fizz 37 38 fizz buzz 41 fizz");
    }
    @Test
    public void playGameProducesOutputRangeOfOne() {
        String playResult = fizzBuzzGameUnderTest.play(20, 20);
        Assertions.assertThat(playResult).isEqualTo("buzz");
    }

    @Test
    public void playGameProducesOutputForNegativeRanges() {
        String playResult = fizzBuzzGameUnderTest.play(-20, 1);
        Assertions.assertThat(playResult).isEqualTo("buzz -19 fizz -17 -16 fizzbuzz -14 -13 fizz -11 buzz fizz -8 -7 fizz buzz -4 fizz -2 -1 fizzbuzz 1");

        playResult = fizzBuzzGameUnderTest.play(-20,-1 );
        Assertions.assertThat(playResult).isEqualTo("buzz -19 fizz -17 -16 fizzbuzz -14 -13 fizz -11 buzz fizz -8 -7 fizz buzz -4 fizz -2 -1");
    }


    @Test
    public void playGameProducesExceptionForInvertedRange() {
        Assertions.assertThatThrownBy(() -> fizzBuzzGameUnderTest.play(20, 1)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("Invalid Range. Provide a valid range of Integers.");
    }
}
