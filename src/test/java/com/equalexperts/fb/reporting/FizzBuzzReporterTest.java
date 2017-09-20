package com.equalexperts.fb.reporting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzReporterTest {


    private FizzBuzzReporter fizzBuzzReporterUnderTest = new FizzBuzzReporter();

    @Test
    public void collectMetrics() {

        fizzBuzzReporterUnderTest.collect("1");
        fizzBuzzReporterUnderTest.collect("fizz");
        fizzBuzzReporterUnderTest.collect("buzz");
        fizzBuzzReporterUnderTest.collect("fizzbuzz");
        fizzBuzzReporterUnderTest.collect("lucky");

        assertThat(fizzBuzzReporterUnderTest.appendReport("result")).isEqualTo("result fizz: 1 buzz: 1 fizzbuzz: 1 lucky: 1 integer: 1");

    }

    @Test
    public void collectMetricsWhenUnknownMetricsWereReported() {

        fizzBuzzReporterUnderTest.collect("1");
        fizzBuzzReporterUnderTest.collect("fizz");
        fizzBuzzReporterUnderTest.collect("buzz");
        fizzBuzzReporterUnderTest.collect("fizzbuzz");
        fizzBuzzReporterUnderTest.collect("unknow");

        assertThat(fizzBuzzReporterUnderTest.appendReport("result")).isEqualTo("result fizz: 1 buzz: 1 fizzbuzz: 1 lucky: 0 integer: 1");

    }
    @Test
    public void collectMetricsWhenMultipleMetricsWereReported() {

        fizzBuzzReporterUnderTest.collect("1");
        fizzBuzzReporterUnderTest.collect("1");
        fizzBuzzReporterUnderTest.collect("fizz");
        fizzBuzzReporterUnderTest.collect("fizz");
        fizzBuzzReporterUnderTest.collect("buzz");
        fizzBuzzReporterUnderTest.collect("buzz");
        fizzBuzzReporterUnderTest.collect("fizzbuzz");
        fizzBuzzReporterUnderTest.collect("fizzbuzz");
        fizzBuzzReporterUnderTest.collect("lucky");
        fizzBuzzReporterUnderTest.collect("lucky");

        assertThat(fizzBuzzReporterUnderTest.appendReport("result")).isEqualTo("result fizz: 2 buzz: 2 fizzbuzz: 2 lucky: 2 integer: 2");

    }
    @Test
    public void collectMetricsWhenNoMetricsWereReported() {
        fizzBuzzReporterUnderTest.collect("1");
        fizzBuzzReporterUnderTest.collect("2");
        fizzBuzzReporterUnderTest.collect("3");

        assertThat(fizzBuzzReporterUnderTest.appendReport("result")).isEqualTo("result fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 3");

    }
}