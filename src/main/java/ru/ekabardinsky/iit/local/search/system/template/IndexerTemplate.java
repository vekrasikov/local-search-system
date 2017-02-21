package ru.ekabardinsky.iit.local.search.system.template;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ekabardinsky on 2/21/17.
 */
@Entity("texts")
public class IndexerTemplate {
    @Id
    private ObjectId id;
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
