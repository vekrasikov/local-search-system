package ru.ekabardinsky.iit.local.search.system.template;

import ru.ekabardinsky.iit.local.search.system.searchEngine.MetricType;
import ru.ekabardinsky.iit.local.search.system.searchEngine.VectorType;

/**
 * Created by ekabardinsky on 2/23/17.
 */
public class SearchTemplate {
    private String searchText;
    private MetricType metricType;
    private VectorType vectorType;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    public void setMetricType(MetricType metricType) {
        this.metricType = metricType;
    }

    public VectorType getVectorType() {
        return vectorType;
    }

    public void setVectorType(VectorType vectorType) {
        this.vectorType = vectorType;
    }
}
