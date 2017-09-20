package com.equalexperts.fb.reporting;

public class FizzBuzzReporter {

    private Metrics metrics = new Metrics();

    public void collect(String result) {
        try {
            Integer.valueOf(result);
            metrics.incrementCounter("integer");
        } catch (Exception ex) {
            metrics.incrementCounter(result);
        }

    }

    public String appendReport(String result) {
        StringBuilder stringBuilder = new StringBuilder(result).append(" ");
        for (String metricName : Metrics.KNOWN_METRIC_NAMES_IN_ORDER) {
            stringBuilder.append(metricName).append(": ").append(metrics.getMetricByNameOrZero(metricName)).append(" ");
        }
        return stringBuilder.toString().trim();
    }


}
