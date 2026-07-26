import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {
    public static void main(String[] args) {

        Collection<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("John");

        System.out.println(names);

        System.out.println(names.contains("Bob"));

        names.remove("John");

        System.out.println(names.size());
    }
}
