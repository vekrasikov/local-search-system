package ru.ekabardinsky.iit.local.search.system.searchEngine;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ekabardinsky.iit.local.search.system.persist.MongoPersistManager;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;
import ru.ekabardinsky.iit.local.search.system.template.SearchResponseTemplate;
import ru.ekabardinsky.iit.local.search.system.template.SearchTemplate;

import static ru.ekabardinsky.iit.local.search.system.searchEngine.calculator.VectorFabric.*;
import static ru.ekabardinsky.iit.local.search.system.searchEngine.calculator.SearchResponseFabric.*;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public class SearchEngine {
    @Autowired
    private MongoPersistManager persistManager;
    @Autowired
    private Indexer indexer;

    public SearchResponseTemplate search(SearchTemplate query) {
        IndexerTemplate searchTemplate = indexer.getIndexerTemplate(query.getSearchText());

        List<IndexerTemplate> foundTemplates = persistManager.searchByTokens(searchTemplate.getTokens());
        HashSet<String> tokens = getTokens(foundTemplates);

        tokens.addAll(searchTemplate.getTokens());
        Vector searchVector = getInstance(searchTemplate, query.getVectorType(), tokens);
        List<Vector> foundVectors = getInstances(foundTemplates, query.getVectorType(), tokens);

        return getResponseInstance(searchVector, foundVectors, query.getMetricType());
    }
}
