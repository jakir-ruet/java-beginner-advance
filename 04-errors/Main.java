
import java.io.FileWriter;
import java.io.IOException;

class InvalidUserException extends Exception {
	public InvalidUserException(String message) {
		super(message);
	}
}

class User {
	String name;
	int age;
	String email;

	public User(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
}

class UserService {
	public void registerUser(User user) throws InvalidUserException{
		// valid user input
		if (user.name == null || user.name.isEmpty()) {
			throw new InvalidUserException("Name can't be emplty");
		}
		if (user.age > 18) {
			throw new InvalidUserException("User must be 18+");
		}
		if (!user.email.contains("@")) {
			throw new InvalidUserException("This invalid email");
		}
		// Simulate file logging
		try(FileWriter writer = new FileWriter("user-log.txt")){
			writer.write("User registration: " + user.name + "\n");
		} catch (IOException e) {
			System.out.println("Logging: " + e.getMessage());
		}
		System.out.println("User registration successfully!");
	}
}

public class Main {
	public static void main(String[] args) {
		UserService service = new UserService();
		User u1 = new User("Jakir", 125, "jakir@gmail.com");
		User u2 = new User("", 25, "hello");

		try{
			service.registerUser(u1);
			service.registerUser(u2);
		} catch (InvalidUserException e) {
			System.out.println("Registration failed: " + e.getMessage());
		} finally {
			System.out.println("Exception completed");
		}
	}
}
