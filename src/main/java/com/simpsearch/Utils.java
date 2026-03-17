package com.simpsearch;

import java.net.*;
import java.net.http.*;
import java.nio.charset.StandardCharsets;

public class Utils {

    private static final HttpClient client =
            HttpClient.newHttpClient();

    public static String encodeQuery(String query) {
        return URLEncoder.encode(query, StandardCharsets.UTF_8);
    }

    public static String buildSearchUrl(String query, int offset) {

        String encoded = encodeQuery(query);

        return "https://search.brave.com/search?q="
                + encoded +
                "&offset=" + offset +
                "&spellcheck=0";
    }

    public static String callHtml2TxtApi(String url) {

        try {

            String api = "https://www.w3.org/services/html2txt?url="
                    + encodeQuery(url);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(api))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request,
                            HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) {
                throw new Exceptions.RequestFailedException(
                        "Request failed: " + response.statusCode());
            }

            return response.body();

        } catch(Exception e) {
            throw new Exceptions.RequestFailedException(e.getMessage());
        }
    }

    public static String removeLinksFromText(String text) {
        return text.replaceAll("https?://\\S+", "");
    }
}