package ru.vkrasikov.iit.local.search.system.searchEngine.calculator;

import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;
import ru.vkrasikov.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;

public interface VectorCalculator {
    Vector calculate (IndexerTemplate template, HashSet<String> tokens);
}
