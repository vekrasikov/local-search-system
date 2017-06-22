package ru.vkrasikov.iit.local.search.system.template;

import java.util.ArrayList;
import org.bson.types.ObjectId;

import java.util.HashSet;
import java.util.List;

public class IndexerTemplate {

    private ObjectId id;
    private String text;
    private List<String> tokenizedText;
    private HashSet<String> tokens;

    public IndexerTemplate(){
        this.setId(new ObjectId());
        this.setText("");
        this.setTokenizedText(new ArrayList<>());
        this.setTokens(new HashSet<>());
    }

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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public boolean equalsText(String comparisonText){
        return this.getText().equals(comparisonText);
    }
    public boolean containsToken(String token){
        return this.getTokens().contains(token);
    }

    public boolean containsAnyToken(HashSet<String> tokens){
        return tokens.stream().anyMatch(token -> this.getTokens().contains(token));
    }
}
