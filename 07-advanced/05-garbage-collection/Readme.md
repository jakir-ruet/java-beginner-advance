### Garbage Collection

Garbage Collection (GC) in Java is the automatic memory management process where the JVM frees up memory by removing objects that are no longer reachable or used by the application.

> **How it works**

When you create objects in Java, they are stored in the `Heap memory`. Over time, some objects become unreachable (no references pointing to them). GC identifies and removes them.

### Types of Garbage Collection

1. Minor GC
   - Cleans Young Generation
   - Fast and frequent
2. Major GC
   - Cleans Old Generation
   - Slower than Minor GC
3. Full GC
   - Cleans entire heap (Young + Old + Metaspace)
   - Most expensive operation
