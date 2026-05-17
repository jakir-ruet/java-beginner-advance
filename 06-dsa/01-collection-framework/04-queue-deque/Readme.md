### Queue (FIFO – First In First Out)

A Queue processes elements in order uses in

- Printer job queue
- Ticket counter
- Task scheduling in servers

### Deque (Double Ended Queue)

A Deque allows insertion and deletion from both ends uses in

- Front > add/remove
- Rear > add/remove

- Browser history (back/forward)
- Undo/Redo system in editors
- Sliding window problems

### Queue vs Deque

| Feature     | Queue            | Deque                 |
| ----------- | ---------------- | --------------------- |
| Order       | FIFO             | Both ends             |
| Insert      | One side (rear)  | Front + Rear          |
| Remove      | One side (front) | Front + Rear          |
| Flexibility | Low              | High                  |
| Use cases   | Task processing  | Undo, browser history |

### Real Production Use Cases

- Queue is used in:
  - Microservice request processing
  - Kafka consumer queues
  - Background job processing
- Deque is used in:
  - LRU (Least Recently Used) Cache design
  - Sliding window algorithm
  - Browser navigation system
