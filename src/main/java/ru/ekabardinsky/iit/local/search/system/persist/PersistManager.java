package ru.ekabardinsky.iit.local.search.system.persist;

import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ekabardinsky on 2/24/17.
 */
public interface PersistManager {
    void saveIfNotExists(IndexerTemplate body);
    List<IndexerTemplate> searchByTokens(HashSet<String> tokens);
    Long countDocumentWithToken(String token);
    Long countAllDocument();
}
