package ru.ekabardinsky.iit.local.search.system.searchEngine;

import ru.ekabardinsky.iit.local.search.system.template.IndexerTemplate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public class Vector {
    private IndexerTemplate template;
    private HashMap<String, Double> vector;

    public Vector(IndexerTemplate template, HashMap<String, Double> vector) {
        this.template = template;
        this.vector = vector;
    }
}
