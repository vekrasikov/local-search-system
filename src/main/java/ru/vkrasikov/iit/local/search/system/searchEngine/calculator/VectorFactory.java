package ru.vkrasikov.iit.local.search.system.searchEngine.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vkrasikov.iit.local.search.system.persist.PersistManager;
import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;
import ru.vkrasikov.iit.local.search.system.searchEngine.VectorType;
import ru.vkrasikov.iit.local.search.system.template.IndexerTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class VectorFactory {
    @Autowired
    private PersistManager persistManager;

    private HashMap<String, Long> countDocumentsByToken(HashSet<String> tokens) {
        HashMap<String, Long> countDocuments = new HashMap<>();

        tokens.forEach(x -> {
            Long count = persistManager.countDocumentWithToken(x);
            countDocuments.put(x, count);
        });
        return countDocuments;
    }

    private VectorCalculator getCalculator(VectorType type, HashSet<String> tokens) {
        VectorCalculator calculator;
        //determinate vector calculator
        if (VectorType.Boolean.equals(type)) {
            calculator = new BooleanVectorCalculator();
        } else if (VectorType.TF.equals(type)) {
            calculator = new TFVectorCalculator();
        } else if (VectorType.TFIDF.equals(type)) {
            calculator = new TFIDFVectorCalculator(countDocumentsByToken(tokens), persistManager.countAllDocument());
        } else {
            throw new IllegalArgumentException("Not expected Vector type: " + type);
        }
        return calculator;
    }

    public Vector getInstance(IndexerTemplate template, VectorType type, HashSet<String> tokens) {
        return getInstance(template, getCalculator(type, tokens), tokens);
    }

    public Vector getInstance(IndexerTemplate template, VectorCalculator calculator, HashSet<String> tokens) {
        return calculator.calculate(template, tokens);
    }

    public List<Vector> getInstances(List<IndexerTemplate> templates, VectorType type, HashSet<String> tokens) {
        return getInstances(templates, getCalculator(type, tokens), tokens);
    }

    public List<Vector> getInstances(List<IndexerTemplate> templates, VectorCalculator calculator, HashSet<String> tokens) {
        List<Vector> vectors = templates
                .stream()
                .map(x -> getInstance(x, calculator, tokens))
                .collect(Collectors.toList());
        return vectors;
    }

    public HashSet<String> getTokens(List<IndexerTemplate> templates) {
        HashSet<String> tokens = new HashSet<>();

        //get unique tokens
        templates.forEach(x -> {
            tokens.addAll(x.getTokens());
        });
        return tokens;
    }
}
