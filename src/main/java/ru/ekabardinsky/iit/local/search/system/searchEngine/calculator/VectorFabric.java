package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import ru.ekabardinsky.iit.local.search.system.searchEngine.VectorType;
import ru.ekabardinsky.iit.local.search.system.searchEngine.calculator.BooleanVectorCalculator;
import ru.ekabardinsky.iit.local.search.system.searchEngine.calculator.TFIDFVectorCalculator;
import ru.ekabardinsky.iit.local.search.system.searchEngine.calculator.TFVectorCalculator;
import ru.ekabardinsky.iit.local.search.system.searchEngine.calculator.VectorCalculator;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public class VectorFabric {
    private static VectorCalculator getCalculator(VectorType type) {
        VectorCalculator calculator;
        //determinate vector calculator
        if (VectorType.Boolean.equals(type)) {
            calculator = new BooleanVectorCalculator();
        } else if (VectorType.TF.equals(type)) {
            calculator = new TFVectorCalculator();
        } else if (VectorType.TFIDF.equals(type)) {
            calculator = new TFIDFVectorCalculator();
        } else {
            throw new IllegalArgumentException("Not expected Vector type: " + type);
        }
        return calculator;
    }

    public static Vector getInstance(IndexerTemplate template, VectorType type, HashSet<String> tokens) {
        return getInstance(template, getCalculator(type), tokens);
    }

    public static Vector getInstance(IndexerTemplate template, VectorCalculator calculator, HashSet<String> tokens) {
        return calculator.calculate(template, tokens);
    }

    public static List<Vector> getInstances(List<IndexerTemplate> templates, VectorType type, HashSet<String> tokens) {
        return getInstances(templates, getCalculator(type), tokens);
    }

    public static List<Vector> getInstances(List<IndexerTemplate> templates, VectorCalculator calculator, HashSet<String> tokens) {
        List<Vector> vectors = templates
                .stream()
                .map(x -> getInstance(x, calculator, tokens))
                .collect(Collectors.toList());
        return vectors;
    }

    public static HashSet<String> getTokens(List<IndexerTemplate> templates) {
        HashSet<String> tokens = new HashSet<>();

        //get unique tokens
        templates.forEach(x -> {
            tokens.addAll(x.getTokens());
        });
        return tokens;
    }
}
