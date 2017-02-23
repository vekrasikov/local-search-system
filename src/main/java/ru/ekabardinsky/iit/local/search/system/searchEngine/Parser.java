package ru.ekabardinsky.iit.local.search.system.searchEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.englishStemmer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class Parser {

    private List<String> badWords;
    @Autowired
    private SnowballStemmer stemmer;
    public Parser(List<String> badWords) {
        this.badWords = new ArrayList<>();

        badWords.forEach(x -> {
            stemmer.setCurrent(x.toLowerCase());
            if (stemmer.stem()) {
                this.badWords.add(stemmer.getCurrent());
            }
        });



    }

    public List<String> parse(String body) {
        body = body.toLowerCase();

        String[] split = body.split("[^a-z]");
        List<String> resultSet = new ArrayList<String>();

        Arrays.stream(split)
                .filter(x -> x != null && !x.isEmpty())
                .filter(x -> !badWords.contains(x))
                .forEach(x -> {
                    stemmer.setCurrent(x);
                    if (stemmer.stem()) {
                        resultSet.add(stemmer.getCurrent());
                    }
                });

        return resultSet;
    }
}
