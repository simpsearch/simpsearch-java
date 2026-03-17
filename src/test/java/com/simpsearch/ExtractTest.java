package com.simpsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtractTest {

    private final SimpSearch client = new SimpSearch();

    @Test
    void testBasicExtraction() {
        String text = client.extract("https://example.com");

        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertTrue(text.toLowerCase().contains("example"));
    }

    @Test
    void testExtractionWithoutInlineRefs() {
        String text = client.extract(
                "https://example.com",
                true,
                false
        );

        assertNotNull(text);
        assertFalse(text.isEmpty());
    }

    @Test
    void testExtractionWithoutNumbers() {
        String text = client.extract(
                "https://example.com",
                false,
                true
        );

        assertNotNull(text);
        assertFalse(text.isEmpty());

        // Rough check: numbers should be minimized
        assertFalse(text.matches(".*\\d+.*"));
    }

    @Test
    void testInvalidUrlHandling() {
        assertThrows(
                Exceptions.RequestFailedException.class,
                () -> client.extract("invalid-url")
        );
    }
}