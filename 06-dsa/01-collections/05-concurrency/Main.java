

class Task extends Thread {
	public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);

            try {
                Thread.sleep(500); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {
	public static void main(String[] args) {
		Task t1 = new Task();
		Task t2 = new Task();

		t1.start();
		t2.start();
	}
}
