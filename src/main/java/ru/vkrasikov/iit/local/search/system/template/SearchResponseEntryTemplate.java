package ru.vkrasikov.iit.local.search.system.template;

import ru.vkrasikov.iit.local.search.system.searchEngine.Vector;

public class SearchResponseEntryTemplate {
    private Vector searchEntry;
    private Double rate;

    public Vector getSearchEntry() {
        return searchEntry;
    }

    public void setSearchEntry(Vector searchEntry) {
        this.searchEntry = searchEntry;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
