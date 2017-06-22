package ru.vkrasikov.iit.local.search.system.searchEngine.calculator;

import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;

import java.util.Set;

class DiceMetricCalculator implements MetricCalculator {
    @Override
    public double calculcate(Vector query, Vector searchEntry) {
        Set<String> dimensions = getDimensions(query, searchEntry);
        double minSum = 0;
        double sum = 0;
        for (String dimension : dimensions) {
            double v = query.getVector().get(dimension);
            double w = searchEntry.getVector().get(dimension);

            minSum += Math.min(v, w);
            sum += v + w;
        }
        minSum *= 2;

        return sum > 0 ? minSum / sum : 0;
    }
}
