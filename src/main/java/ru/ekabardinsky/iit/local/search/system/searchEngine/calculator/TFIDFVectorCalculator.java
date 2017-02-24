package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.persist.PersistManager;
import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/23/17.
 */
class TFIDFVectorCalculator implements VectorCalculator {

    private HashMap<String, Long> countDocumentsByTokens;
    private Long allDocumentCount;

    public TFIDFVectorCalculator(HashMap<String, Long> countDocumentsByTokens, Long allDocumentCount) {
        this.countDocumentsByTokens = countDocumentsByTokens;
        this.allDocumentCount = allDocumentCount;
    }

    @Override
    public Vector calculate(IndexerTemplate template, HashSet<String> tokens) {
        HashMap<String, Double> vector = new HashMap<>();

        tokens.forEach(x -> {
            double tf = template
                    .getTokenizedText()
                    .stream()
                    .filter(y -> y.equals(x))
                    .count();
            double idf = Math.log((double) allDocumentCount / countDocumentsByTokens.get(x));
            vector.put(x, tf * idf);
        });

        return new Vector(template, vector);
    }
}
