### Lambda Expression

A lambda expression in Java is a short and concise way to represent an anonymous function (function without a name), mainly used to implement functional interfaces.

**Syntax**

```bash
(parameters) -> { body }
```

```bash
() -> System.out.println("Hello"); // No Parameter
```

```bash
name -> System.out.println(name); // One Parameter (no parentheses needed)
```

```bash
(a, b) -> a + b; // Multiple Parameters
```

```bash
// With Block Body
(a, b) -> {
    int sum = a + b;
    return sum;
}
```

**Before Lambda (Anonymous Class)**

```bash
interface MyFunctionalInterface {
    void show();
}

public class Main {
    public static void main(String[] args) {

        MyFunctionalInterface obj = new MyFunctionalInterface() {
            public void show() {
                System.out.println("Hello World");
            }
        };

        obj.show();
    }
}
```

**With Lambda Expression**

```bash
interface MyFunctionalInterface {
    void show();
}

public class Main {
    public static void main(String[] args) {

        MyFunctionalInterface obj = () -> {
            System.out.println("Hello World");
        };

        obj.show();
    }
}
```
