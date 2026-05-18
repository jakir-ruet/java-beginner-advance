### Process

A running program with its own isolated memory space. An instance of a program in execution, containing its own memory address space, resources, and at least one thread.

**Key Characteristics:**

- Has its own memory space (isolated from other processes)
- Contains at least one thread
- Cannot directly access another process's memory
- Has its own process ID (PID)
- Takes more resources to create than threads

```bash
chrome.exe 	(PID 1234) - Process
word.exe 	(PID 5678) - Process
spotify.exe (PID 9012) - Process
```

### Thread

A process is a running program with its own memory space. A thread is a `lightweight` unit inside a process that shares that memory space with other threads in the same process.

![Threading-Architecture](/img/threading-architecture.jpg)

### Types of Thread

In Java (especially Java SE 21), threads are mainly of two types:

- Physical (Platform) Threads
- Virtual Threads

Both are used for concurrency, but they work very differently.

### Physical vs Virtual Thread

| Feature                | Physical (Platform) Threads      | Virtual Threads (Java 21)                     |
| ---------------------- | -------------------------------- | --------------------------------------------- |
| Definition             | OS-managed threads used by JVM   | JVM-managed lightweight threads               |
| Managed by             | Operating System (Kernel)        | JVM (Project Loom)                            |
| Introduced in Java     | Since early versions             | Java 21                                       |
| Weight                 | Heavy                            | Very lightweight                              |
| Creation cost          | High                             | Very low                                      |
| Memory usage           | High (MB per thread stack)       | Very low (shared stack management)            |
| Scalability            | Limited (thousands)              | Very high (millions possible)                 |
| Execution mapping      | 1:1 with OS threads              | Many-to-few (multiplexed on platform threads) |
| Scheduling             | OS scheduler                     | JVM scheduler                                 |
| Blocking behavior      | Blocks OS thread                 | JVM parks/unblocks efficiently                |
| Best suited for        | CPU-intensive tasks              | I/O-heavy tasks (API, DB, network)            |
| Context switching cost | High                             | Very low                                      |
| Performance bottleneck | Thread exhaustion                | Rare (designed for scale)                     |
| Example use case       | Image processing, computations   | REST APIs, microservices, database calls      |
| Java API example       | `new Thread()`                   | `Thread.startVirtualThread()`                 |
| Executor example       | `Executors.newFixedThreadPool()` | `Executors.newVirtualThreadPerTaskExecutor()` |

```bash
YOUR COMPUTER = A GIANT RESTAURANT KITCHEN
│
├── Physical Stoves = HARDWARE THREADS (8 total)
│
├── Cookbooks = PROCESSES (20 running on your PC)
│   │
│   ├── 📘 COOKBOOK #1: Chrome Browser Process
│   │   ├── Recipe 1 (Thread): UI Renderer
│   │   ├── Recipe 2 (Thread): Network Handler
│   │   ├── Recipe 3 (Thread): JavaScript Engine
│   │   └── ... (50 more recipes/threads)
│   │
│   ├── 📘 COOKBOOK #2: Microsoft Word Process
│   │   ├── Recipe 1 (Thread): Spell Check
│   │   ├── Recipe 2 (Thread): Auto-Save
│   │   ├── Recipe 3 (Thread): UI Responsiveness
│   │   └── ... (12 more recipes/threads)
│   │
│   ├── 📘 COOKBOOK #3: Spotify Process
│   │   ├── Recipe 1 (Thread): Audio Playback
│   │   ├── Recipe 2 (Thread): Download Songs
│   │   ├── Recipe 3 (Thread): UI Animation
│   │   └── ... (8 more recipes/threads)
│   │
│   └── ... (17 more cookbooks/processes)
│
└── 👨‍🍳 Head Chef = OS SCHEDULER
    └── Decides which recipe from which cookbook goes on which stove, and when
```

```bash
HIERARCHY:
						YOUR COMPUTER
							  │
			┌─────────────┴─────────────┐
			│                           │
	HARDWARE                      SOFTWARE
(Physical Stoves)              (Cookbooks + Recipes)
			│                           │
8 Hardware Threads          20 Processes (Cookbooks)
			│                   3,413 Threads (Recipes)
			│                           │
			└─────────────┬─────────────┘
							  │
					OS SCHEDULER
						(Head Chef)
							  │
			┌─────────────┴─────────────┐
			│                           │
Decides WHICH recipe          Assigns to WHICH stove
(software thread)             (hardware thread)
			│                           │
			└─────────────┬─────────────┘
							  │
						EXECUTION
						(Cooking!)
```

> **Threads** > The fundamental unit of concurrency in Java.

**Real-life examples**

- Web server handling multiple users
- Banking system processing transactions
- YouTube uploading + streaming at the same time
- Kubernetes pods handling parallel requests

**Core Idea**

| Term        | Meaning                                                        |
| ----------- | -------------------------------------------------------------- |
| Process     | Running program                                                |
| Thread      | Small unit of execution inside a process                       |
| Concurrency | Multiple threads running together                              |
| Parallelism | Multiple tasks running literally at the same time (multi-core) |

### OS Scheduler

The kernel component responsible for allocating CPU time (hardware threads) to runnable software threads, using algorithms like round-robin, priority-based, or fair scheduling.
