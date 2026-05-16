### Memory Management

Memory management in Java is the process of:

- Allocating memory to programs
- Storing variables and objects
- Managing program execution memory
- Automatically removing unused memory

> - Java handles memory automatically using the: `Garbage Collector (GC)`
> - This is one of the major advantages of Java over languages like C or C++, where developers manually manage memory.

### Why Memory Management is Important (Memory management helps)

- Improve application performance
- Avoid memory leaks
- Prevent crashes
- Efficiently use system resources
- Support large enterprise applications

### JVM (Java Virtual Machine)

Java programs run inside `JVM (Java Virtual Machine)` and JVM is responsible for:

- Loading classes
- Executing bytecode
- Managing memory
- Running garbage collection

### JVM Memory Architeccture

![JVM Memory Architeccture](/img/jvm-memory-architeccture.png)

### JVM Memory Architeccture

![JVM Memory Architeccture](/img/stack-heap.png)

### Memory Area Details

This section defines the primary purpose of each memory segment within the JVM.

| Memory Area         | Description                                                                                           |
| ------------------- | ----------------------------------------------------------------------------------------------------- |
| Stack Memory        | Used for method execution. Stores local variables, method calls, object references, and stack frames. |
| Heap Memory         | Stores all runtime objects and arrays. Managed by Garbage Collector (GC).                             |
| Metaspace           | Stores class metadata, method data, constant pool, and class loader information. Uses native memory.  |
| PC Register         | Stores the address of the currently executing JVM instruction for each thread.                        |
| Native Method Stack | Used for executing native (C/C++) methods via JNI.                                                    |
| Code Cache          | Stores JIT (Just-In-Time) compiled native machine code for frequently executed methods.               |
| String Pool         | Special memory area inside Heap for storing string literals to optimize memory usage.                 |
| Direct Memory       | Memory outside JVM Heap used for high-performance I/O (NIO, Kafka, buffers).                          |

### Detailed Comparison of JVM Memory Areas

A deep dive into how these areas behave, their lifespans, and common failure points.

| Memory Area         | Location      | Shared/Thread-Specific | Lifetime                     | Common Issues                   | Real Example         |
| ------------------- | ------------- | ---------------------- | ---------------------------- | ------------------------------- | -------------------- |
| Stack Memory        | JVM Runtime   | Thread-specific        | Until method finishes        | StackOverflowError              | `int x = 10;`        |
| Heap Memory         | JVM Runtime   | Shared                 | Until object is unreachable  | OutOfMemoryError                | `new Employee()`     |
| Metaspace           | Native Memory | Shared                 | Until class unloading        | OutOfMemoryError                | `Employee.class`     |
| PC Register         | Per-thread    | Thread-specific        | While thread exists          | Rare issues                     | Instruction tracking |
| Code Cache          | JVM Runtime   | Shared                 | JVM lifetime                 | Cache full / performance issues | JIT compiled methods |
| String Pool         | Inside Heap   | Shared                 | JVM lifetime                 | Excessive string creation       | `"Java"` literal     |
| Native Method Stack | Native memory | Thread-specific        | Native method execution time | JNI crashes                     | C/C++ calls          |

### Stack vs Heap Comparison

| Feature       | Stack Memory                     | Heap Memory              |
| ------------- | -------------------------------- | ------------------------ |
| Speed         | Very fast                        | Slower than stack        |
| Structure     | LIFO (Last In First Out)         | Dynamic / Non-linear     |
| Thread Safety | Thread-safe (private per thread) | Not thread-safe (shared) |
| Allocation    | Automatic (method calls)         | Dynamic (`new` keyword)  |
| Cleanup       | Automatic (method ends)          | Garbage Collector (GC)   |
| Size          | Smaller & fixed                  | Larger & expandable      |
| Stores        | Local variables, references      | Objects, arrays          |
| Errors        | StackOverflowError               | OutOfMemoryError         |

### JVM Memory – Golden Rules

| Rule | Explanation                                                   |
| ---- | ------------------------------------------------------------- |
| 1    | Local variables (primitives & references) go to Stack         |
| 2    | Objects and arrays always go to Heap                          |
| 3    | Instance variables are stored inside Heap (as part of object) |
| 4    | Each method call creates a Stack Frame                        |
| 5    | String literals are stored in String Pool (Heap)              |
| 6    | Garbage Collector only manages Heap memory                    |
| 7    | Metaspace stores class-level metadata, not objects            |

### String Pool?

- Special memory area inside heap.
- Stores reusable string literals.
