package com.simpsearch;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    private final SimpSearch client = new SimpSearch();

    @Test
    void testRawSearch() {
        String result = client.raw("hello world");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.toLowerCase().contains("hello"));
    }

    @Test
    void testTextSearch() {
        String result = client.text("hello world");

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // Ensure links are removed
        assertFalse(result.contains("http"));
    }

    @Test
    void testLinksExtraction() {
        List<String> links = client.links("open source");

        assertNotNull(links);
        assertFalse(links.isEmpty());

        for (String link : links) {
            assertTrue(link.startsWith("http"));
        }
    }

    @Test
    void testParsedResults() {
        List<Map<String, String>> results =
                client.parsed("java programming");

        assertNotNull(results);
        assertFalse(results.isEmpty());

        Map<String, String> first = results.get(0);

        assertTrue(first.containsKey("title"));
        assertTrue(first.containsKey("link"));
        assertTrue(first.containsKey("snippet"));
    }

    @Test
    void testPagination() {
        List<Map<String, String>> page1 =
                client.parsed("ai tools", 0);

        List<Map<String, String>> page2 =
                client.parsed("ai tools", 10);

        assertNotEquals(page1, page2);
    }
}