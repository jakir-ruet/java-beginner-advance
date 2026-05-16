**Encapsulation means:** Wrapping data (variables) and methods together into a single unit (class) and restricting direct access to the data. We must:

- declare class variables/attributes as `private`
- provide public `get` and `set` methods to access and update the value of a private variable

**What is Getter?** A method used to read private variable value.

**What is Setter?** A method used to assign/update private variable value.

**Getter and Setter are methods used to:**

- `Getter` → read/get data
- `Setter` → write/set data
- They are mainly used with: `private variables`

**Why Needed?**

Suppose you have:

```bash
class Employee {
    private double salary;
}
```

> ❌ Direct access NOT allowed. Because salary is **private**

```bash
Employee e = new Employee();
e.salary = 50000;   // ERROR
```

**So we use:**
- `setter` → to assign value
- `getter` → to read value

**Setter Method Purpose**

Set value into variable.

```bash
class Employee {
    // private variable
    private double salary;
    // setter
    public void setSalary(double s) {
        salary = s;
    }
    // getter
    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        // set value
        e.setSalary(50000);
        // get value
        System.out.println(e.getSalary());
    }
}
```

**Simple Analogy**

Think about a TV.

- `Setter` → remote control changes channel
- `Getter` → display shows current channel

> You don’t directly touch internal circuit.

**Encapsulation vs Abstraction**

| Feature     | Encapsulation            | Abstraction                |
| ----------- | ------------------------ | -------------------------- |
| Focus       | Data hiding              | Implementation hiding      |
| Achieved by | Class + access modifiers | Abstract class / Interface |
| Hides       | Variables (data)         | Logic (implementation)     |
| Purpose     | Security + control       | Simplicity + design        |
| Level       | Code level               | Design level               |
