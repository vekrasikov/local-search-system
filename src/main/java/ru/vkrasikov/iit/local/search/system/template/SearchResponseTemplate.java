package ru.vkrasikov.iit.local.search.system.template;

import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;

import java.util.List;

public class SearchResponseTemplate {
    private Vector query;
    private String status;
    private List<SearchResponseEntryTemplate> templates;

    public SearchResponseTemplate(Vector query, String status) {
        this.query = query;
        this.status = status;
    }

    public List<SearchResponseEntryTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<SearchResponseEntryTemplate> templates) {
        this.templates = templates;
    }

    public Vector getQuery() {
        return query;
    }

    public String getStatus() {
        return status;
    }
}
