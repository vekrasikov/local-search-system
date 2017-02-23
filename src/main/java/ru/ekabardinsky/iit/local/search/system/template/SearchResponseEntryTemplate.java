package ru.ekabardinsky.iit.local.search.system.template;

import ru.ekabardinsky.iit.local.search.system.searchEngine.Vector;

/**
 * Created by ekabardinsky on 2/23/17.
 */
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
