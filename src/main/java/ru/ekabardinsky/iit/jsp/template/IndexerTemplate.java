package ru.ekabardinsky.iit.jsp.template;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ekabardinsky on 2/21/17.
 */
public class IndexerTemplate {
    private String text;
    private List<String> tokenizedText;
    private HashSet<String> tokens;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTokenizedText() {
        return tokenizedText;
    }

    public void setTokenizedText(List<String> tokenizedText) {
        this.tokenizedText = tokenizedText;
    }

    public HashSet<String> getTokens() {
        return tokens;
    }

    public void setTokens(HashSet<String> tokens) {
        this.tokens = tokens;
    }
}
