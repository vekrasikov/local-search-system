package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public interface VectorCalculator {
    Vector calculate (IndexerTemplate template, HashSet<String> tokens);
}
