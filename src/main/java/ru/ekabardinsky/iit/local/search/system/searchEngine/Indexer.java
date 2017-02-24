package ru.ekabardinsky.iit.local.search.system.searchEngine;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ekabardinsky.iit.local.search.system.persist.PersistManager;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class Indexer {
    @Autowired
    private Parser parser;

    @Autowired
    PersistManager persistManager;

    public IndexerTemplate index(IndexerTemplate body) {
        IndexerTemplate indexerTemplate = parser.getIndexerTemplate(body.getText());
        persistManager.saveIfNotExists(indexerTemplate);
        return indexerTemplate;
    }
}
