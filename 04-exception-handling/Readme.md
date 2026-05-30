### Exceptions Handling

Error handling in Java is mainly done using `exceptions`. An exception is an event that disrupts the normal flow of a program. Java provides a structured mechanism using `try`, `catch`, `finally`, `throw`, and `throws`.

### Tree Structure

```bash
Error Handling in Java
│
├── Types of Errors
│   ├── Compile-time Errors
│   │   └── Syntax mistakes (detected by compiler)
│   │
│   ├── Runtime Errors (Exceptions)
│   │   ├── Checked Exceptions
│   │   │   ├── IOException
│   │   │   ├── SQLException
│   │   │   └── FileNotFoundException
│   │   │
│   │   └── Unchecked Exceptions
│   │       ├── ArithmeticException
│   │       ├── NullPointerException
│   │       └── ArrayIndexOutOfBoundsException
│   │
│   └── Logical Errors
│       └── Wrong output but program runs
│
├── Exception Handling Mechanism
│   ├── try
│   ├── catch
│   ├── finally
│   ├── throw
│   └── throws
│
├── Control Flow Concepts
│   ├── Multiple catch blocks
│   ├── Nested try-catch
│   └── try-with-resources
│
├── Custom Exceptions
│   ├── User-defined exception class
│   └── extends Exception / RuntimeException
│
└── Best Practices
    ├── Catch specific exceptions first
    ├── Avoid empty catch blocks
    ├── Use logging instead of print
    └── Clean resources properly
```
