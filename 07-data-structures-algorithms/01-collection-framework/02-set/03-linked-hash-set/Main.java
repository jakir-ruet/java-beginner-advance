import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {

        LinkedHashSet<String> loggedUsers = new LinkedHashSet<>();

        // User logins
        loggedUsers.add("jakir");
        loggedUsers.add("admin");
        loggedUsers.add("devops");
        loggedUsers.add("cloudteam");

        // Duplicate login
        loggedUsers.add("jakir");

        System.out.println("Logged Users History:");

        for (String user : loggedUsers) {
            System.out.println(user);
        }

        // Check user exists
        if (loggedUsers.contains("admin")) {
            System.out.println("\nAdmin is logged in.");
        }

        // Remove disconnected user
        loggedUsers.remove("devops");

        System.out.println("\nAfter Removing devops:");

        for (String user : loggedUsers) {
            System.out.println(user);
        }
    }
}
