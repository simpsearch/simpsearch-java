package com.simpsearch;

import java.util.List;
import java.util.Map;

public class SimpSearch {

    private final SearchService searchService;
    private final ExtractService extractService;

    public SimpSearch() {
        this.searchService = new SearchService();
        this.extractService = new ExtractService();
    }

    public String raw(String query) {
        return searchService.raw(query, 0);
    }

    public String raw(String query, int offset) {
        return searchService.raw(query, offset);
    }

    public String text(String query) {
        return searchService.text(query, 0);
    }

    public String text(String query, int offset) {
        return searchService.text(query, offset);
    }

    public List<String> links(String query) {
        return searchService.links(query, 0);
    }

    public List<String> links(String query, int offset) {
        return searchService.links(query, offset);
    }

    public List<Map<String,String>> parsed(String query) {
        return searchService.parsed(query, 0);
    }

    public List<Map<String,String>> parsed(String query, int offset) {
        return searchService.parsed(query, offset);
    }

    public String extract(String url) {
        return extractService.extract(url, false, false);
    }

    public String extract(String url, boolean noInlineRefs, boolean removeNumbers) {
        return extractService.extract(url, noInlineRefs, removeNumbers);
    }
}