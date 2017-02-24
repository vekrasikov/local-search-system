package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/23/17.
 */
class TFVectorCalculator implements VectorCalculator {
    @Override
    public Vector calculate(IndexerTemplate template, HashSet<String> tokens) {
        HashMap<String, Double> vector = new HashMap<>();
        tokens.forEach(x -> {
            long count = template
                    .getTokenizedText()
                    .stream()
                    .filter(y -> y.equals(x))
                    .count();
            vector.put(x, (double) count);
        });

        return new Vector(template, vector);
    }
}
