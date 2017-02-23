package ru.ekabardinsky.iit.local.search.system.template;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public class SearchResponseTemplate {
    private List<SearchResponseEntryTemplate> templates;

    public SearchResponseTemplate() {
        templates = new ArrayList<>();
    }

    public List<SearchResponseEntryTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<SearchResponseEntryTemplate> templates) {
        this.templates = templates;
    }

}
