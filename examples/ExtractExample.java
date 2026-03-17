import com.simpsearch.SimpSearch;

public class ExtractExample {

    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        String text = client.extract("https://example.com");

        System.out.println(text);
    }
}