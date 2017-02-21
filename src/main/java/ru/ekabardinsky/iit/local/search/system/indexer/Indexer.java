package ru.ekabardinsky.iit.local.search.system.indexer;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ekabardinsky.iit.local.search.system.parser.Parser;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class Indexer {
    @Autowired
    private Parser parser;

    @Autowired
    private Datastore datastore;

    public IndexerTemplate index(IndexerTemplate body) {
        body.setTokenizedText(parser.parse(body.getText()));
        HashSet<String> tokenSet = new HashSet<>(body.getTokenizedText());
        body.setTokens(tokenSet);

        //persist template to mongo
        Query<IndexerTemplate> existsDuplicate = datastore
                .createQuery(IndexerTemplate.class)
                .field("text")
                .equal(body.getText());
        long countExistsDuplicate = datastore.getCount(existsDuplicate);
        if (countExistsDuplicate == 0) {
            datastore.save(body);
        }
        return body;
    }
}
