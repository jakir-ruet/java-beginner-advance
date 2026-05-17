import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Create LinkedHashMap
        LinkedHashMap<Integer, String> pageHistory = new LinkedHashMap<>();

        System.out.println("User Visit History:");

        // Simulating user visiting pages
        pageHistory.put(100, "Google");
        pageHistory.put(150, "YouTube");
        pageHistory.put(200, "GitHub");
        pageHistory.put(250, "ChatGPT");

        // Print all entries
        for (Map.Entry<Integer, String> entry : pageHistory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
