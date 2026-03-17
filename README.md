
# 🧾 Before You Start

### 1. Add Dependency

#### Gradle

```gradle
implementation "com.simpsearch:simpsearch:1.0.0"
```

#### Maven

```xml
<dependency>
  <groupId>com.simpsearch</groupId>
  <artifactId>simpsearch</artifactId>
  <version>1.0.0</version>
</dependency>
```

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

# 💡 Bonus: Kotlin Full Working Example

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

# 🧠 Pro Tip for Beginners

If you're new:

👉 Run examples one by one
👉 Start with Example1
👉 Then try Example5 (real website extraction)

