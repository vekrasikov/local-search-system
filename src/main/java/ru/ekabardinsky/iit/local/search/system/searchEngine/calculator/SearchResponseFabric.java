package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.MetricType;
import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;
import ru.ekabardinsky.iit.local.search.system.template.SearchResponseEntryTemplate;
import ru.ekabardinsky.iit.local.search.system.template.SearchResponseTemplate;

import java.util.List;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public class SearchResponseFabric {
    private static MetricCalculator getCalculator(MetricType type) {
        MetricCalculator calculator;

        if (MetricType.Cosin.equals(type)) {
            calculator = new CosinMetricCalculator();
        } else if (MetricType.Dice.equals(type)) {
            calculator = new DiceMetricCalculator();
        } else if (MetricType.Jaccard.equals(type)) {
            calculator = new JaccardMetricCalculator();
        } else {
            throw new IllegalArgumentException("Not expected Metric type: " + type);
        }
        return calculator;
    }

    public static SearchResponseEntryTemplate getEntryInstance(Vector query, Vector searchEntry, MetricType type) {
        return getEntryInstance(query, searchEntry, getCalculator(type));
    }

    public static SearchResponseEntryTemplate getEntryInstance(Vector query, Vector searchEntry, MetricCalculator calculator) {
        SearchResponseEntryTemplate template = new SearchResponseEntryTemplate();
        template.setSearchEntry(searchEntry);
        template.setRate(calculator.calculcate(query, searchEntry));
        return template;
    }

    public static SearchResponseTemplate getResponseInstance(Vector query, List<Vector> searchEntries, MetricType type) {
        return getResponseInstance(query, searchEntries, getCalculator(type));
    }

    public static SearchResponseTemplate getResponseInstance(Vector query, List<Vector> searchEntries, MetricCalculator calculator) {
        SearchResponseTemplate responseTemplate = new SearchResponseTemplate();
        searchEntries.forEach(x -> {
            responseTemplate.getTemplates().add(getEntryInstance(query, x, calculator));
        });

        return responseTemplate;
    }

}
