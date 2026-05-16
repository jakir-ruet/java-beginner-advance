import java.util.HashSet;

class ActiveSessionManager {

    private static HashSet<String> activeUsers = new HashSet<>();

    public static void login(String userId) {
        if (activeUsers.contains(userId)) {
            System.out.println("User " + userId + " is already logged in.");
        } else {
            activeUsers.add(userId);
            System.out.println("User " + userId + " logged in successfully.");
        }
    }

    public static void logout(String userId) {
        if (activeUsers.remove(userId)) {
            System.out.println("User " + userId + " logged out successfully.");
        } else {
            System.out.println("User " + userId + " is not logged in.");
        }
    }

    public static HashSet<String> getActiveUsers() {
        return new HashSet<>(activeUsers); // safe copy
    }
}

public class Main {
    public static void main(String[] args) {

        ActiveSessionManager.login("user1");
        ActiveSessionManager.login("user2");
        ActiveSessionManager.login("user3");

        System.out.println("Active users: " + ActiveSessionManager.getActiveUsers());

        ActiveSessionManager.logout("user2");

        System.out.println("Active users after removal: " +
                ActiveSessionManager.getActiveUsers());
    }
}
