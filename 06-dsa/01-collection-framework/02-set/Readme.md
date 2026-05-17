### Set

The Set `interface` is part of the Java Collections Framework and is used to store a collection of `unique elements`.

| Feature      | HashSet                                                      | LinkedHashSet                                                   | TreeSet                                                      |
| ------------ | ------------------------------------------------------------ | --------------------------------------------------------------- | ------------------------------------------------------------ |
| Order        | No                                                           | Insertion                                                       | Sorted                                                       |
| Speed        | Fast                                                         | Medium                                                          | Slow                                                         |
| Structure    | Hash                                                         | Hash + List                                                     | Tree                                                         |
| Null allowed | Yes                                                          | Yes                                                             | No                                                           |
| Use case     | Unique data (e.g., tracking unique user IDs)                 | Ordered unique data (e.g., recently viewed products)            | Sorted unique data (e.g., leaderboard scores, sorted prices) |
|              | Unique data (e.g., preventing duplicate email registrations) | Ordered unique data (e.g., maintaining form submission history) | Sorted unique data (e.g., scheduling by priority)            |

> **Why it is called HashSet**

Because it uses a hash function to convert each element into a numeric hash code, which decides where the element will be stored in memory.
