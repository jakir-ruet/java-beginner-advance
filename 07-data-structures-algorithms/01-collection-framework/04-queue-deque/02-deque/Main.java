
import java.util.ArrayDeque;
import java.util.Deque;

class myDeque {
	Deque<String> deque = new ArrayDeque<>();

	public myDeque() {
		deque.add("Task-1");
		deque.add("Task-2");
		deque.add("Task-3");
		deque.add("Task-4");
	}

	// Show current deque
	void showDeque() {
		System.out.println("Deque: " + deque);
	}

	// Remove from deque

	void removeElement() {
		System.out.println("Removed 1st Element: " + deque.remove());
		System.out.println("Removed 2nd Element: " + deque.remove());
	}
}
public class Main {
	public static void main(String[] args) {
		myDeque d = new myDeque();
		d.showDeque();
		d.removeElement();
		d.showDeque();
	}
}
