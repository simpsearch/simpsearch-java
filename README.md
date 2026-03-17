# 🔍 SimpSearch

> Lightweight Java/Kotlin library for web search + clean text extraction using W3C html2txt.

[![](https://jitpack.io/v/simpsearch/simpsearch-java.svg)](https://jitpack.io/#simpsearch/simpsearch-java)

---

# 🚀 Features

* 🔎 Web search using Brave
* 🌐 Website text extraction
* 📄 Raw search output
* ✂️ Clean text (no links)
* 🔗 Link extraction
* 📊 Structured parsed results (title, link, snippet)
* 📑 Pagination support
* ☕ Works in Java & Kotlin
* ⚡ Lightweight (no heavy dependencies)

---

# 📦 Installation

## Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.simpsearch:simpsearch-java:1.0.0'
}
```

---

## Maven

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.simpsearch</groupId>
  <artifactId>simpsearch-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

---

# ⚡ Quick Start

## Java

```java
import com.simpsearch.SimpSearch;

public class Main {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        System.out.println(client.parsed("hello world"));
    }
}
```

---

## Kotlin

```kotlin
import com.simpsearch.SimpSearch

fun main() {
    val client = SimpSearch()
    println(client.parsed("hello world"))
}
```

---

# 🧠 How It Works (Beginner Friendly)

1. Your query goes to **Brave Search**
2. Search page is sent to **W3C html2txt**
3. HTML is converted into clean readable text
4. SimpSearch extracts:

   * Titles
   * Links
   * Snippets

---

# ✅ 10 COMPLETE WORKING EXAMPLES

---

## 1. Basic Search (Structured Results)

```java
import com.simpsearch.SimpSearch;
import java.util.*;

public class Example1 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        List<Map<String, String>> results =
                client.parsed("java tutorial");

        for (Map<String, String> item : results) {
            System.out.println("Title: " + item.get("title"));
            System.out.println("Link: " + item.get("link"));
            System.out.println("Snippet: " + item.get("snippet"));
            System.out.println("------------");
        }
    }
}
```

---

## 2. Raw Search Output

```java
import com.simpsearch.SimpSearch;

public class Example2 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        String raw = client.raw("open source tools");

        System.out.println(raw);
    }
}
```

---

## 3. Clean Text (No Links)

```java
import com.simpsearch.SimpSearch;

public class Example3 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        String text = client.text("machine learning");

        System.out.println(text);
    }
}
```

---

## 4. Extract Only Links

```java
import com.simpsearch.SimpSearch;
import java.util.*;

public class Example4 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        List<String> links = client.links("best websites");

        for (String link : links) {
            System.out.println(link);
        }
    }
}
```

---

## 5. Website Text Extraction

```java
import com.simpsearch.SimpSearch;

public class Example5 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        String content = client.extract("https://example.com");

        System.out.println(content);
    }
}
```

---

## 6. Extraction Without Inline References

```java
import com.simpsearch.SimpSearch;

public class Example6 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        String content = client.extract(
                "https://example.com",
                true,
                false
        );

        System.out.println(content);
    }
}
```

---

## 7. Extraction Without Numbers

```java
import com.simpsearch.SimpSearch;

public class Example7 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        String content = client.extract(
                "https://example.com",
                false,
                true
        );

        System.out.println(content);
    }
}
```

---

## 8. Pagination Example

```java
import com.simpsearch.SimpSearch;
import java.util.*;

public class Example8 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        List<Map<String, String>> page1 =
                client.parsed("ai tools", 0);

        List<Map<String, String>> page2 =
                client.parsed("ai tools", 10);

        System.out.println("Page 1:");
        for (Map<String, String> item : page1) {
            System.out.println(item.get("title"));
        }

        System.out.println("\nPage 2:");
        for (Map<String, String> item : page2) {
            System.out.println(item.get("title"));
        }
    }
}
```

---

## 9. Search + Extract (Real Use Case)

```java
import com.simpsearch.SimpSearch;
import java.util.*;

public class Example9 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        List<String> links =
                client.links("java frameworks");

        if (!links.isEmpty()) {

            String firstLink = links.get(0);

            System.out.println("Extracting from: " + firstLink);

            String content = client.extract(firstLink);

            System.out.println(content);
        }
    }
}
```

---

## 10. Error Handling Example

```java
import com.simpsearch.SimpSearch;

public class Example10 {
    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        try {
            String result = client.extract("invalid-url");
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error occurred:");
            System.out.println(e.getMessage());
        }
    }
}
```

---

# 💡 Bonus: Kotlin Full Example

```kotlin
import com.simpsearch.SimpSearch

fun main() {

    val client = SimpSearch()

    val results = client.parsed("android development")

    for (item in results) {
        println("Title: ${item["title"]}")
        println("Link: ${item["link"]}")
        println("Snippet: ${item["snippet"]}")
        println("------------")
    }
}
```

---

# 🧩 API Summary

| Method        | Description                |
| ------------- | -------------------------- |
| raw(query)    | Full raw text              |
| text(query)   | Clean text (links removed) |
| links(query)  | Extract only links         |
| parsed(query) | Structured results         |
| extract(url)  | Website text extraction    |

---

# ⚠️ Notes

* Internet connection required
* Uses Brave Search + W3C html2txt
* Avoid too many rapid requests (rate limits may apply)

---

# 🤝 Contributing

Contributions are welcome!

1. Fork the repo
2. Create a new branch
3. Make changes
4. Submit a pull request

---

# 📄 License

MIT License

---

# ❤️ Final Note

SimpSearch is designed to be **simple, fast, and beginner-friendly**.

If you're learning:

* Web scraping
* Java networking
* Text processing

👉 This library is a great starting point.

---

Happy coding 🚀
