import com.simpsearch.SimpSearch;

public class SearchExample {

    public static void main(String[] args) {

        SimpSearch client = new SimpSearch();

        System.out.println(client.parsed("hello world"));

        System.out.println(client.links("open source search"));

    }
}