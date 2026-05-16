### Java Collection

The Java Collection Framework is a unified architecture that provides a set of interfaces, implementations, and algorithms to store, manage, and manipulate groups of objects efficiently.

### Collection Framework Tree

```bash
├ Collection Framework
├── 01-list
│   ├── 01-array-list
│   │
│   ├── 02-linked-list
│   │   ├── 01-singly-linked-list
│   │   │
│   │   ├── 02-doubly-linked-list
│   │   │
│   │   ├── 03-circular-linked-list
│   │   │
│   │   └── 04-circular-doubly-linked-list
│
├── 02-set
│   ├── 01-hash-set
│   │
│   ├── 02-linked-hash-set
│   │
│   ├── 03-tree-set
│
├── 03-map
│   ├── 01-hash-map
│   │
│   ├── 02-linked-hash-map
│   │
│   ├── 03-tree-map
│
├── 04-queue-and-deque
│   ├── 01-queue
│   │
│   ├── 02-priority-queue
│   │
│   ├── 03-array-deque
│
├── 05-concurrency-collections
│   ├── 01-concurrent-hash-map
│   │
│   ├── 02-blocking-queue
│   │
│   ├── 03-thread-safe-list
```

### List

| Type       | Order           | Duplicates | Access Speed | Insert/Delete      | Best Use              |
| ---------- | --------------- | ---------- | ------------ | ------------------ | --------------------- |
| ArrayList  | Maintains order | Yes        | Fast (O(1))  | Slow middle        | Read-heavy apps       |
| LinkedList | Maintains order | Yes        | Slow (O(n))  | Fast insert/delete | Queue-like operations |

### LinkedList

| Type                        | Structure           | Use Case                   |
| --------------------------- | ------------------- | -------------------------- |
| Singly Linked List          | one-way chain       | simple stack/queue         |
| Doubly Linked List          | two-way navigation  | browser history            |
| Circular Linked List        | looped structure    | round-robin scheduling     |
| Circular Doubly Linked List | full loop both ways | complex navigation systems |

### Set

| Type          | Order           | Duplicates    | Speed    | Sorting | Best Use            |
| ------------- | --------------- | ------------- | -------- | ------- | ------------------- |
| HashSet       | No order        | No duplicates | O(1)     | No      | Fast lookup         |
| LinkedHashSet | Insertion order | No            | O(1)     | No      | Ordered unique data |
| TreeSet       | Sorted order    | No            | O(log n) | Yes     | Sorted unique data  |

### Map

| Type          | Order           | Sorting | Speed    | Nulls            | Best Use      |
| ------------- | --------------- | ------- | -------- | ---------------- | ------------- |
| HashMap       | No order        | No      | O(1)     | Yes (1 null key) | Cache, lookup |
| LinkedHashMap | Insertion order | No      | O(1)     | Yes              | LRU cache     |
| TreeMap       | Sorted by key   | Yes     | O(log n) | No null key      | Sorted config |

### Queue & Deque

| Type          | Order              | Behavior                | Speed     | Best Use             |
| ------------- | ------------------ | ----------------------- | --------- | -------------------- |
| Queue         | FIFO               | First In First Out      | O(1)      | Task processing      |
| PriorityQueue | Priority-based     | Smallest/highest first  | O(log n)  | Scheduling           |
| ArrayDeque    | Double-ended queue | Insert/remove both ends | Very fast | Stack + Queue hybrid |

### Concurrency

| Type                 | Thread-safe | Performance           | Use Case           |
| -------------------- | ----------- | --------------------- | ------------------ |
| ConcurrentHashMap    | Yes         | High                  | Distributed cache  |
| BlockingQueue        | Yes         | Blocking ops          | Producer-Consumer  |
| CopyOnWriteArrayList | Yes         | Slow write, fast read | Read-heavy systems |

### Order + Speed + Use

| Category    | Ordered? | Fastest           | Thread-safe | Real-world role |
| ----------- | -------- | ----------------- | ----------- | --------------- |
| List        | Yes      | ArrayList         | No          | Data storage    |
| Set         | Partial  | HashSet           | No          | Uniqueness      |
| Map         | Partial  | HashMap           | No          | Lookup/cache    |
| Queue       | Yes      | ArrayDeque        | No          | Processing      |
| Concurrency | Depends  | ConcurrentHashMap | Yes         | Backend systems |

### Use

| Collection        | Real Backend Use                |
| ----------------- | ------------------------------- |
| ArrayList         | REST API response list          |
| LinkedList        | Task queue/buffer             |
| HashSet           | Dedup logs/validation         |
| TreeSet           | Leaderboards                    |
| HashMap           | Cache system (Redis-like logic) |
| LinkedHashMap     | LRU cache                       |
| Queue             | Job processing (Kafka-like)     |
| BlockingQueue     | Producer-consumer system        |
| ConcurrentHashMap | Multi-thread cache              |
