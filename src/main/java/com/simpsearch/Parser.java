package com.simpsearch;

import java.util.*;
import java.util.regex.*;

public class Parser {

    private static final Pattern LINK_PATTERN =
            Pattern.compile("https?://\\S+");

    public static List<String> parseLinks(String text) {

        List<String> links = new ArrayList<>();
        Matcher m = LINK_PATTERN.matcher(text);

        while(m.find()) {
            links.add(m.group());
        }

        return links;
    }

    public static List<Map<String,String>> parseResults(String text) {

        List<Map<String,String>> results = new ArrayList<>();

        String[] blocks = text.split("\n\n");

        for(String block : blocks) {

            List<String> links = parseLinks(block);

            if(links.isEmpty()) continue;

            Map<String,String> item = new HashMap<>();

            String[] lines = block.split("\n");

            String title = lines.length > 0 ? lines[0] : "";
            String snippet = block.replace(title, "");

            item.put("title", title.trim());
            item.put("link", links.get(0));
            item.put("snippet", snippet.trim());

            results.add(item);
        }

        return results;
    }
}