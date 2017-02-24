package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by ekabardinsky on 2/23/17.
 */
class CosinMetricCalculator implements MetricCalculator {
    @Override
    public double calculcate(Vector query, Vector searchEntry) {
        Set<String> dimensions = getDimensions(query, searchEntry);

        double frequencyMultiply = 0;
        double squareV = 0;
        double squareW = 0;
        for (String dimension : dimensions) {
            double v = query.getVector().get(dimension);
            double w = searchEntry.getVector().get(dimension);

            frequencyMultiply += v * w;
            squareV += v * v;
            squareW += w * w;
        }
        double square = squareV * squareW;
        return square != 0 ? frequencyMultiply / square : 0;
    }
}
