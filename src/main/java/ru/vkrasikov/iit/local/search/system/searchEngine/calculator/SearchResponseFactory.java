package ru.vkrasikov.iit.local.search.system.searchEngine.calculator;

import ru.vkrasikov.iit.local.search.system.searchEngine.MetricType;
import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;
import ru.vkrasikov.iit.local.search.system.template.SearchResponseEntryTemplate;
import ru.vkrasikov.iit.local.search.system.template.SearchResponseTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResponseFactory {
    private MetricCalculator getCalculator(MetricType type) {
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

    public SearchResponseEntryTemplate getEntryInstance(Vector query, Vector searchEntry, MetricType type) {
        return getEntryInstance(query, searchEntry, getCalculator(type));
    }

    public SearchResponseEntryTemplate getEntryInstance(Vector query, Vector searchEntry, MetricCalculator calculator) {
        SearchResponseEntryTemplate template = new SearchResponseEntryTemplate();
        template.setSearchEntry(searchEntry);
        template.setRate(calculator.calculcate(query, searchEntry));
        return template;
    }

    public SearchResponseTemplate getResponseInstance(Vector query, List<Vector> searchEntries, MetricType type) {
        return getResponseInstance(query, searchEntries, getCalculator(type));
    }

    public SearchResponseTemplate getResponseInstance(Vector query, List<Vector> searchEntries, MetricCalculator calculator) {
        SearchResponseTemplate responseTemplate = new SearchResponseTemplate(query, "Found " + searchEntries.size() + " entries");
        List<SearchResponseEntryTemplate> searchResponseEntryTemplates = searchEntries
                .stream()
                .map(x -> getEntryInstance(query, x, calculator))
                .sorted((x, y) -> -Double.compare(x.getRate(), y.getRate()))
                .collect(Collectors.toList());
        responseTemplate.setTemplates(searchResponseEntryTemplates);
        return responseTemplate;
    }

}
