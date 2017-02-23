package ru.ekabardinsky.iit.local.search.system.persist;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class MongoPersistManager {
    @Autowired
    private Datastore datastore;

    public void saveIfNotExists(IndexerTemplate body) {
        //persist template to mongo
        Query<IndexerTemplate> existsDuplicate = datastore
                .createQuery(IndexerTemplate.class)
                .field("text")
                .equal(body.getText());
        long countExistsDuplicate = datastore.getCount(existsDuplicate);
        if (countExistsDuplicate == 0) {
            datastore.save(body);
        }
    }
    public List<IndexerTemplate> searchByTokens(HashSet<String> tokens) {
        Query<IndexerTemplate> searchByTokensQuery = datastore
                .createQuery(IndexerTemplate.class)
                .field("tokens")
                .hasAnyOf(tokens);

        List<IndexerTemplate> indexerTemplates = searchByTokensQuery.asList();
        return indexerTemplates;
    }
}
