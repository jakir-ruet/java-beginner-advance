### Overview

`S``O``L``I``D` principles are a set of five design principles that help you write clean, maintainable, and scalable object-oriented code in Java (and other OOP languages). They’re especially useful when your projects start growing and you want to avoid messy, tightly coupled code.

**1. S — Single Responsibility Principle (SRP)** A class should have only one reason to change. That means one class should do only one job.

**Bad example**

```bash
class Report {
    void generateReport() {
        // generate report
    }

    void saveToFile() {
        // save file logic
    }
}
```

> This class is doing two things: generating and saving.

**Good example**

```bash
class ReportGenerator {
    void generateReport() {
        // generate report
    }
}

class ReportSaver {
    void saveToFile() {
        // save file logic
    }
}
```

> Now each class has a single responsibility.

**2. O — Open/Closed Principle (OCP)** Software entities should be open for extension but closed for modification. You should be able to add new features without changing existing code.

**Bad example**

```bash
class AreaCalculator {
    double calculate(Object shape) {
        if (shape instanceof Circle) {
            // calculate circle area
        } else if (shape instanceof Rectangle) {
            // calculate rectangle area
        }
        return 0;
    }
}
```

> Every time you add a new shape, you must modify this class.

**Good example**

```bash
interface Shape {
    double area();
}

class Circle implements Shape {
    public double area() {
        return Math.PI * r * r;
    }
}

class Rectangle implements Shape {
    public double area() {
        return width * height;
    }
}
```

> Now you can add new shapes without changing existing code.

**3. L — Liskov Substitution Principle (LSP)** Subtypes must be substitutable for their base types. If class B is a subclass of A, you should be able to use B wherever A is expected.

**Bad example**

```bash
class Bird {
    void fly() {}
}

class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

> Penguin “is a Bird” but cannot fly → violates LSP.

**Good example**

```bash
interface Bird {}

interface FlyingBird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() {}
}

class Penguin implements Bird {
    // no fly method
}
```

> Now behavior is correctly separated.

**4. I — Interface Segregation Principle (ISP)** Clients should not be forced to depend on methods they do not use. Use small, focused interfaces instead of large ones.

**Bad example**

```bash
interface Worker {
    void work();
    void eat();
}
```

> A robot doesn’t eat, but must implement it.

**Good example**

```bash
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {}
    public void eat() {}
}

class Robot implements Workable {
    public void work() {}
}
```

**5. D — Dependency Inversion Principle (DIP)** Depend on abstractions, not on concrete classes. High-level modules should not depend on low-level modules.

**Bad example**

```bash
class OracleDatabase {
    void connect() {}
}

class UserService {
    OracleDatabase db = new OracleDatabase();
}
```

> Tightly coupled to Oracle.

**Good example**

```bash
interface Database {
    void connect();
}

class OracleDatabase implements Database {
    public void connect() {}
}

class UserService {
    private Database db;

    UserService(Database db) {
        this.db = db;
    }
}
```

> Now you can switch databases easily (Oracle, MongoDB, etc.).
