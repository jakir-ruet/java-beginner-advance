class Worker extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Worker t1 = new Worker();
        Worker t2 = new Worker();
        t1.start();
        t2.start();
    }
}
