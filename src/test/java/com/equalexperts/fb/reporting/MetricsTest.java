package com.equalexperts.fb.reporting;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MetricsTest {


    @Test
    public void incrementAnyCounterInteger() {
        Metrics metrics = new Metrics();
        metrics.incrementCounter("integer");
        Assertions.assertThat(metrics.getMetricByNameOrZero("integer")).isEqualTo(1);

        metrics.incrementCounter("othercounter");
        Assertions.assertThat(metrics.getMetricByNameOrZero("othercounter")).isEqualTo(1);
    }

    @Test
    public void returnZeroForUnknownCounter() {
        Metrics metrics = new Metrics();
        Assertions.assertThat(metrics.getMetricByNameOrZero("unkknow")).isEqualTo(0);


    }
}