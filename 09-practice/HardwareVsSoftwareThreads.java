public class HardwareVsSoftwareThreads {

    public static void main(String[] args) {
        // Get hardware threads (provided by CPU)
        int hardwareThreads = Runtime.getRuntime().availableProcessors();

        System.out.println("=== HARDWARE THREADS ===");
        System.out.println("CPU provides: " + hardwareThreads + " hardware threads");
        System.out.println("These are physical execution units on your CPU");
        System.out.println("You cannot change this number - it's fixed!\n");

        // Create software threads (we can make as many as we want)
        System.out.println("=== SOFTWARE THREADS ===");
        System.out.println("Creating 100 software threads...\n");

        java.util.List<Thread> softwareThreads = new java.util.ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int id = i;
            Thread t = new Thread(() -> {
                System.out.println("Software Thread " + id + " is running on hardware thread: " +
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(100); // Simulate work
                } catch (InterruptedException e) {}
            });
            t.start();
            softwareThreads.add(t);
        }

        // Wait for all software threads to finish
        for (Thread t : softwareThreads) {
            try { t.join(); } catch (InterruptedException e) {}
        }

        System.out.println("\n=== SUMMARY ===");
        System.out.println("Hardware threads available: " + hardwareThreads);
        System.out.println("Software threads created: " + softwareThreads.size());
        System.out.println("Result: " + softwareThreads.size() + " software threads");
        System.out.println("        shared " + hardwareThreads + " hardware threads");
        System.out.println("        through OS scheduling!");
    }
}
