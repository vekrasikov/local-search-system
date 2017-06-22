package ru.vkrasikov.iit.local.search.system.searchEngine.calculator;

import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;

import java.util.Set;

class JaccardMetricCalculator implements MetricCalculator {
    @Override
    public double calculcate(Vector query, Vector searchEntry) {
        Set<String> dimensions = getDimensions(query, searchEntry);
        double minSum = 0;
        double maxSum = 0;
        for (String dimension : dimensions) {
            double v = query.getVector().get(dimension);
            double w = searchEntry.getVector().get(dimension);

            minSum += Math.min(v, w);
            maxSum += Math.max(v, w);
        }

        return maxSum > 0 ? minSum / maxSum : 0;
    }
}
