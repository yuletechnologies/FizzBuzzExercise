package com.equalexperts.fb.reporting;

import java.util.HashMap;
import java.util.Map;

/**
 * Non Thread Safe Object
 */
 class Metrics {
    static final String[] KNOWN_METRIC_NAMES_IN_ORDER = {"fizz", "buzz", "fizzbuzz", "lucky", "integer"};

    private Map<String, Long> counters = new HashMap<>(KNOWN_METRIC_NAMES_IN_ORDER.length);

    void incrementCounter(String counter) {
        if (counters.containsKey(counter)) {
            Long theCounterValue = counters.get(counter);
            counters.put(counter, ++theCounterValue);
        } else {
            counters.put(counter, 1L);
        }
    }

    Long getMetricByNameOrZero(String metricName) {
        return counters.containsKey(metricName) ? counters.get(metricName) : 0l;
    }
}
