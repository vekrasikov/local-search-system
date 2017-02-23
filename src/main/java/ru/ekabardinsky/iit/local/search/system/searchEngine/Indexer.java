package ru.ekabardinsky.iit.local.search.system.searchEngine;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ekabardinsky.iit.local.search.system.searchEngine.Parser;
import ru.ekabardinsky.iit.local.search.system.persist.MongoPersistManager;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class Indexer {
    @Autowired
    private Parser parser;

    @Autowired
    MongoPersistManager persistManager;

    public IndexerTemplate index(IndexerTemplate body) {
        body.setTokenizedText(parser.parse(body.getText()));
        HashSet<String> tokenSet = new HashSet<>(body.getTokenizedText());
        body.setTokens(tokenSet);

        persistManager.saveIfNotExists(body);

        return body;
    }
    public IndexerTemplate getIndexerTemplate(String body) {
        IndexerTemplate template = new IndexerTemplate();
        template.setTokenizedText(parser.parse(body));
        template.setTokens(new HashSet<>(template.getTokenizedText()));

        return template;
    }
}
