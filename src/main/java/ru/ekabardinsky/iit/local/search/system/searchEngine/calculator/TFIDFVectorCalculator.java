package ru.ekabardinsky.iit.local.search.system.searchEngine.calculator;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;
import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/23/17.
 */
class TFIDFVectorCalculator implements VectorCalculator {
    @Override
    public Vector calculate(IndexerTemplate template, HashSet<String> tokens) {
        throw new NotImplementedException();
    }
}
