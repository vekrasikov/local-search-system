package ru.ekabardinsky.iit.jsp.indexer;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ekabardinsky.iit.jsp.parser.Parser;
import ru.ekabardinsky.iit.jsp.template.IndexerTemplate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class Indexer {
    @Autowired
    private Parser parser;

    public IndexerTemplate index(IndexerTemplate body) {
        body.setTokenizedText(parser.parse(body.getText()));
        HashSet<String> tokenSet = new HashSet<>(body.getTokenizedText());
        body.setTokens(tokenSet);

        return body;
    }
}
