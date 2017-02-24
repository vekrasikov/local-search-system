package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public interface MetricCalculator {
    double calculcate(Vector query, Vector searchEntry);

    default Set<String> getDimensions(Vector query, Vector searchEntry) {
        HashMap<String, Double> queryVector = query.getVector();
        HashMap<String, Double> searchEntryVector = searchEntry.getVector();

        if (!queryVector.keySet().equals(searchEntryVector.keySet())) {
            throw new IllegalArgumentException("Vectors dimension not equals");
        }

        return query.getVector().keySet();
    }
}
