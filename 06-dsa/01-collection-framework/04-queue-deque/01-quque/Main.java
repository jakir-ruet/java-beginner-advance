
import java.util.LinkedList;
import java.util.Queue;

class myQueue {
	Queue<String> queue = new LinkedList<>();

	myQueue() {
		queue.add("Task-1");
		queue.add("Task-2");
		queue.add("Task-3");
    }
	 void showQueqe() {
		System.out.println("Queqe: " + queue);
	 }
}
public class Main {
	public static void main(String[] args) {
		myQueue q = new myQueue();
		q.showQueqe();

		// Remove element - FIFO
		System.out.println("Removed: " + q.queue.poll());
		q.showQueqe();
	}
}
