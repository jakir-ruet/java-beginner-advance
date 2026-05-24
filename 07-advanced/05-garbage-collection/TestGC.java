public class TestGC {
    public static void main(String[] args) {
        TestGC obj1 = new TestGC();
        TestGC obj2 = new TestGC();

        obj1 = null;  // eligible for GC
        obj2 = null;  // eligible for GC

        System.gc();   // request JVM to run GC (not guaranteed)
    }

    protected void finalize() {
        System.out.println("Object garbage collected");
    }
}
