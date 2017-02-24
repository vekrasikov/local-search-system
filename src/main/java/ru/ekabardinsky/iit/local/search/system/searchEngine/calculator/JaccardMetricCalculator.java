package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by ekabardinsky on 2/23/17.
 */
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
        minSum *= 2;

        return maxSum > 0 ? minSum / maxSum : 0;
    }
}
