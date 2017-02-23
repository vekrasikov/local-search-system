package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public interface MetricCalculator {
    double calculcate(Vector query, Vector searchEntry);
}
