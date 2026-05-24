### Execution Modes

Execution modes describe how tasks are executed by the CPU/JVM depending on scheduling, hardware, and programming model.

![Execution Modes](/img/execution-modes.jpg)

### Concurrency

Concurrency means multiple tasks make progress during overlapping time periods. In Java, concurrency allows a program to:

- Execute multiple tasks simultaneously,
- Improve performance,
- Handle many users,
- Utilize CPU efficiently,
- Build scalable applications.

Examples:

- Web servers handling thousands of requests
- Kubernetes controllers
- CI/CD pipelines
- Banking systems
- Chat applications

### Types of Concurrency

| Type                       | Description                       |
| -------------------------- | --------------------------------- |
| Process-based concurrency  | Multiple processes                |
| Thread-based concurrency   | Multiple threads inside a process |
| Cooperative concurrency    | Tasks voluntarily yield           |
| Preemptive concurrency     | OS/JVM controls scheduling        |
| Asynchronous concurrency   | Non-blocking execution            |
| Parallel concurrency       | Multi-core execution              |
| Reactive concurrency       | Event-driven asynchronous model   |
| Structured concurrency     | Grouped task management           |
| Virtual-thread concurrency | Lightweight threads in Java 21    |

### Parallelism

Parallelism means multiple tasks execute at the same time on multiple CPU cores. It is used when work is split into parts and each part runs simultaneously. Typical use cases:

- CPU-intensive computations
- Big data processing
- Image/video processing

### Concurrency vs Parallelism

| Feature           | Concurrency                                         | Parallelism                                            |
| ----------------- | --------------------------------------------------- | ------------------------------------------------------ |
| Definition        | Multiple tasks are managed together                 | Multiple tasks execute at the same time                |
| Execution Style   | Tasks overlap in time                               | Tasks run simultaneously                               |
| CPU Requirement   | Can work on a single CPU/core                       | Requires multiple CPU cores                            |
| Task Switching    | CPU rapidly switches between tasks                  | Different cores execute tasks independently            |
| Goal              | Improve responsiveness and resource utilization     | Improve speed and throughput                           |
| Real Execution    | Not necessarily simultaneous                        | Truly simultaneous                                     |
| Example Scenario  | Web server handling many requests                   | Large data processing across cores                     |
| Java Example      | Multithreading with thread scheduling               | Parallel streams, ForkJoinPool                         |
| Analogy           | One chef cooking multiple dishes by switching tasks | Multiple chefs cooking different dishes simultaneously |
| Performance Focus | Better task management                              | Faster computation                                     |
| Typical Use Cases | I/O-bound applications, APIs, chat systems          | CPU-intensive tasks, big data, scientific computing    |

![Concurrency vs Parallelism](/img/concurrency-parallelism.jpg)
