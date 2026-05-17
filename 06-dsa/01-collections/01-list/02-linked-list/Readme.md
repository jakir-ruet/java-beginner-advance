### Linked List

A linked list is a linear data structure where elements are stored as separate objects called nodes. Each node contains:

- Data
- Reference (pointer) to another node

**Unlike arrays:**

- Arrays store elements in contiguous memory
- Linked lists store elements dynamically in memory

### Types of Linked Lists

- Singly Linked List (SLL)
- Doubly Linked List (DLL)
- Circular Linked List (CLL)
- Circular Doubly Linked List

### Comparison

| **Feature**          | **SLL (Singly LL)** | **DLL (Doubly LL)**        | **CLL (Circular SLL)**      | **CDLL (Circular DLL)**           |
| -------------------- | ------------------- | -------------------------- | --------------------------- | --------------------------------- |
| Direction            | One-way             | Two-way                    | One-way                     | Two-way                           |
| Last node points to  | null                | null                       | head                        | head                              |
| Previous pointer     | No                  | Yes                        | No                          | Yes                               |
| Circular structure   | No                  | No                         | Yes                         | Yes                               |
| Memory usage         | Low                 | Medium                     | Low                         | High                              |
| Node structure       | data + next         | data + prev + next         | data + next                 | data + prev + next                |
| Traversal type       | Linear              | Bidirectional              | Circular linear             | Circular bidirectional            |
| Forward traversal    | O(n)                | O(n)                       | O(n) (loop)                 | O(n) (loop)                       |
| Backward traversal   | Not possible        | O(n)                       | Not possible                | O(n) / O(1)                       |
| Insert at head       | O(1)                | O(1)                       | O(1)                        | O(1)                              |
| Insert at tail       | O(n) / O(1)*        | O(1)*                      | O(1)*                       | O(1)                              |
| Delete node          | O(n)                | O(1)*                      | O(n)                        | O(1)*                             |
| Search               | O(n)                | O(n)                       | O(n)                        | O(n)                              |
| Complexity (overall) | Simple              | Medium                     | Medium                      | Complex                           |
| Real-world use cases | Stack, queue basics | Browser history, undo/redo | CPU scheduling, round robin | Music player, advanced schedulers |
