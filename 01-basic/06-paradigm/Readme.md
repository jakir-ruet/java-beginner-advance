### 1. Imperative Programming

Tell the computer how to perform a task, step by step. Java's basic statements are imperative:

**Key characteristics:**

- Variables and state
- Assignment
- Loops
- Conditional statements
- Sequential execution

### 2. Procedural Programming

Organize a program around procedures/functions that perform operations.

> Java is not primarily a procedural language like C,
> because Java requires everything to exist within a class,
> but Java can certainly use a procedural programming style.

### 3. Object-Oriented Programming

This is the primary paradigm of traditional Java programming. Model software using objects that contain:

- State → fields
- Behavior → methods

```bash
Student
   │
   ├── State
   │    ├── id
   │    └── name
   │
   └── Behavior
        └── display()
```

**Four major OOP principles**

| Principle     | Meaning                            |
| ------------- | ---------------------------------- |
| Encapsulation | Bundle data and behavior together  |
| Abstraction   | Hide implementation details        |
| Inheritance   | Derive one class from another      |
| Polymorphism  | Same interface, different behavior |

### 4. Declarative Programming

Describe what you want, rather than explicitly describing every step of how to achieve it. Java itself has traditionally been imperative, but modern Java provides several declarative-style APIs.

> The Stream API encourages a more declarative style.

### 5. Functional Programming

Java became significantly more functional-oriented starting with Java 8. Functional programming treats functions as values and emphasizes:

- Functions
- Lambda expressions
- Immutability
- Higher-order functions
- Function composition
- Stream processing
- Avoidance of unnecessary mutable state
