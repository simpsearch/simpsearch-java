package com.simpsearch;

import java.util.List;
import java.util.Map;

public class SearchService {

    public String raw(String query, int offset) {
        String url = Utils.buildSearchUrl(query, offset);
        return Utils.callHtml2TxtApi(url);
    }

    public String text(String query, int offset) {
        String raw = raw(query, offset);
        return Utils.removeLinksFromText(raw);
    }

    public List<String> links(String query, int offset) {
        String raw = raw(query, offset);
        return Parser.parseLinks(raw);
    }

    public List<Map<String,String>> parsed(String query, int offset) {
        String raw = raw(query, offset);
        return Parser.parseResults(raw);
    }
}