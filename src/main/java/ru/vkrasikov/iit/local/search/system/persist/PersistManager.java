package ru.vkrasikov.iit.local.search.system.persist;

import ru.vkrasikov.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;
import java.util.List;

public interface PersistManager {
    void saveIfNotExists(IndexerTemplate body);
    List<IndexerTemplate> searchByTokens(HashSet<String> tokens);
    Long countDocumentWithToken(String token);
    Long countAllDocument();
}
