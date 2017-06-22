package ru.vkrasikov.iit.local.search.system.searchEngine;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vkrasikov.iit.local.search.system.persist.PersistManager;
import ru.vkrasikov.iit.local.search.system.searchEngine.calculator.SearchResponseFactory;
import ru.vkrasikov.iit.local.search.system.searchEngine.calculator.VectorFactory;
import ru.vkrasikov.iit.local.search.system.template.IndexerTemplate;
import ru.vkrasikov.iit.local.search.system.template.SearchResponseTemplate;
import ru.vkrasikov.iit.local.search.system.template.SearchTemplate;

import java.util.HashSet;
import java.util.List;

public class SearchEngine {
    @Autowired
    private PersistManager persistManager;
    @Autowired
    private Parser parser;
    @Autowired
    private VectorFactory vectorFactory;
    @Autowired
    private SearchResponseFactory searchResponseFactory;

    public SearchResponseTemplate search(SearchTemplate query) {
        IndexerTemplate searchTemplate = parser.getIndexerTemplate(query.getSearchText());

        List<IndexerTemplate> foundTemplates = persistManager.searchByTokens(searchTemplate.getTokens());
        if (foundTemplates.size() > 0) {
            HashSet<String> tokens = vectorFactory.getTokens(foundTemplates);
            tokens.addAll(searchTemplate.getTokens());
            Vector searchVector = vectorFactory.getInstance(searchTemplate, query.getVectorType(), tokens);
            List<Vector> foundVectors = vectorFactory.getInstances(foundTemplates, query.getVectorType(), tokens);

            return searchResponseFactory.getResponseInstance(searchVector, foundVectors, query.getMetricType());
        } else {
            return new SearchResponseTemplate(null, "Not Found");
        }
    }
}
