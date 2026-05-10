## More About Me – [Take a Look!](http://www.mjakaria.me)

### Java

Java is a high-level, general-purpose, memory-safe, object-oriented programming language. It is intended to let programmers write once, run anywhere, meaning that compiled Java code can run on all platforms that support Java without the need to recompile.

#### Literals

These are fixed values that appear directly in the code. They don't change.

| Literal Type       | Description                                   | Example                 |
| ------------------ | --------------------------------------------- | ----------------------- |
| Integer Literals   | Whole numbers without decimals                | `10`, `-5`, `1000`      |
| Long Literals      | Large whole numbers (`L` or `l` suffix)       | `100L`, `5000L`         |
| Float Literals     | Decimal numbers with `f` suffix               | `3.14f`, `2.5f`         |
| Double Literals    | Decimal numbers (default floating-point type) | `3.14`, `2.5`, `1.0e-6` |
| Character Literals | Single character inside single quotes         | `'A'`, `'9'`, `'$'`     |
| String Literals    | Sequence of characters inside double quotes   | `"Hello"`, `"Java"`     |
| Boolean Literals   | Logical values                                | `true`, `false`         |

#### Primitive Data Types

Java has 8 primitive data types. These are predefined by the language and store simple values.

| Data Type | Size    | Description          | Example                |
| --------- | ------- | -------------------- | ---------------------- |
| `byte`    | 1 byte  | Small integer        | `byte b = 100;`        |
| `short`   | 2 bytes | Short integer        | `short s = 5000;`      |
| `int`     | 4 bytes | Integer value        | `int n = 100000;`      |
| `long`    | 8 bytes | Large integer        | `long l = 100000L;`    |
| `float`   | 4 bytes | Decimal number       | `float f = 3.14f;`     |
| `double`  | 8 bytes | Large decimal number | `double d = 99.99;`    |
| `char`    | 2 bytes | Single character     | `char c = 'A';`        |
| `boolean` | 1 bit*  | True/False value     | `boolean flag = true;` |

##### Arithmetic Operators

| Operator | Meaning             | Example |
| -------- | ------------------- | ------- |
| `+`      | Addition            | `a + b` |
| `-`      | Subtraction         | `a - b` |
| `*`      | Multiplication      | `a * b` |
| `/`      | Division            | `a / b` |
| `%`      | Modulus (Remainder) | `a % b` |

##### Assignment Operators

| Operator | Example  | Same As     |
| -------- | -------- | ----------- |
| `=`      | `x = 5`  | Assign 5    |
| `+=`     | `x += 3` | `x = x + 3` |
| `-=`     | `x -= 2` | `x = x - 2` |
| `*=`     | `x *= 4` | `x = x * 4` |
| `/=`     | `x /= 2` | `x = x / 2` |

##### Relational (Comparison) Operators

| Operator | Meaning               | Example  |
| -------- | --------------------- | -------- |
| `==`     | Equal to              | `a == b` |
| `!=`     | Not equal to          | `a != b` |
| `>`      | Greater than          | `a > b`  |
| `<`      | Less than             | `a < b`  |
| `>=`     | Greater than or equal | `a >= b` |
| `<=`     | Less than or equal    | `a <= b` |

##### Logical Operators

| Operator | Meaning     | Example             |
| -------- | ----------- | ------------------- |
| `&&`     | Logical AND | `a > 5 && b < 10`   |
| `\|\|`   | Logical OR  | `a > 5 \|\| b < 10` |
| `!`      | Logical NOT | `!(a > b)`          |

##### Increment and Decrement Operators

| Operator | Meaning             |
| -------- | ------------------- |
| `++`     | Increase value by 1 |
| `--`     | Decrease value by 1 |

##### Unary Operators

| Operator | Meaning     |
| -------- | ----------- |
| `+`      | Positive    |
| `-`      | Negative    |
| `++`     | Increment   |
| `--`     | Decrement   |
| `!`      | Logical NOT |

##### Ternary Operator

- Short form of `if-else` - `condition ? value1 : value2;`

```bash
int age = 18;
String result = (age >= 18) ? "Adult" : "Minor";
System.out.println(result);
```

##### Bitwise Operators

| Operator | Meaning            |            |
| -------- | ------------------ | ---------- |
| `&`      | Bitwise AND        |            |
| `        | `                  | Bitwise OR |
| `^`      | Bitwise XOR        |            |
| `~`      | Bitwise Complement |            |
| `<<`     | Left Shift         |            |
| `>>`     | Right Shift        |            |

#### Non-Primitive

Non-primitive data types (reference types) are more complex than primitives. They refer to memory locations where data is stored, rather than storing the actual data directly.

##### Types of Non-Primitive Data Types

| Type      | Description                         | Example                      |
| --------- | ----------------------------------- | ---------------------------- |
| String    | Sequence of characters              | `"Hello"`                    |
| Array     | Stores multiple values of same type | `int[] nums = {1,2,3};`      |
| Class     | Blueprint for objects               | `Student s = new Student();` |
| Object    | Instance of a class                 | `new Student()`              |
| Interface | Contract for classes                | `interface Drawable`         |

##### Strings

| Feature             | Example                             |
| ------------------- | ----------------------------------- |
| String Literal      | `String str = "Hello";`             |
| Using `new`         | `String str = new String("Hello");` |
| Length              | `str.length()`                      |
| Uppercase           | `str.toUpperCase()`                 |
| Lowercase           | `str.toLowerCase()`                 |
| Character Access    | `str.charAt(1)`                     |
| Comparison          | `str1.equals(str2)`                 |
| Concatenation       | `first + last`                      |
| Substring           | `str.substring(0,4)`                |
| Mutable Alternative | `StringBuilder`                     |

##### Arrays

| Feature                 | Example              |
| ----------------------- | -------------------- |
| Declare Array           | `int[] nums;`        |
| Create Array            | `new int[5]`         |
| Initialize Array        | `{1,2,3}`            |
| Access Element          | `nums[0]`            |
| Array Length            | `nums.length`        |
| Loop Through Array      | `for(int n : nums)`  |
| Multi-dimensional Array | `int[][] matrix`     |
| Array of Objects        | `Student[] students` |

##### Classes and Objects

| Concept      | Example             |
| ------------ | ------------------- |
| Class        | `class Student {}`  |
| Object       | `new Student()`     |
| Field        | `String name;`      |
| Constructor  | `Student(String n)` |
| Method       | `void study()`      |
| Access Field | `student.name`      |
| Call Method  | `student.study()`   |

##### Interfaces

| Feature             | Example                            |
| ------------------- | ---------------------------------- |
| Define Interface    | `interface Drawable {}`            |
| Abstract Method     | `void draw();`                     |
| Default Method      | `default void print(){}`           |
| Static Method       | `static void info(){}`             |
| Implement Interface | `class Circle implements Drawable` |

##### Enums (Enumerations)

An Enum (Enumeration) is a special type used to define a fixed set of constants.

**Why Use Enums?** Enums make code:

- More readable
- Safer
- Easier to maintain

Instead of using numbers or strings, use meaningful constant names.

#### Primitive vs Non-Primitive

| Feature       | Primitive                  | Non-Primitive                     |
| ------------- | -------------------------- | --------------------------------- |
| Storage       | Stores actual value        | Stores reference (memory address) |
| Default Value | `0`, `0.0`, `false`, etc.  | `null`                            |
| Methods       | No methods                 | Can have methods                  |
| Size          | Fixed size                 | Dynamic size                      |
| Built-in      | Yes (8 types)              | Created by programmer or Java     |
| Examples      | `int`, `double`, `boolean` | `String`, Arrays, Classes         |

#### Types of Type Casting

| Type                         | Description                              | Example          |
| ---------------------------- | ---------------------------------------- | ---------------- |
| Widening Casting (Implicit)  | Smaller type → Larger type automatically | `int` → `double` |
| Narrowing Casting (Explicit) | Larger type → Smaller type manually      | `double` → `int` |

> - **Widening Casting:** `byte → short → int → long → float → double`
> - **Narrowing Casting:** `double → float → long → int → short → byte`

##### Type Casting Table

| Original Type    | Converted To | Casting Type |
| ---------------- | ------------ | ------------ |
| `int` → `double` | Automatic    | Widening     |
| `char` → `int`   | Automatic    | Widening     |
| `int` → `long`   | Automatic    | Widening     |
| `double` → `int` | Manual       | Narrowing    |
| `long` → `short` | Manual       | Narrowing    |
| `int` → `byte`   | Manual       | Narrowing    |

## With Regards, `Jakir`

[![LinkedIn][linkedin-shield-jakir]][linkedin-url-jakir]
[![Facebook-Page][facebook-shield-jakir]][facebook-url-jakir]
[![Youtube][youtube-shield-jakir]][youtube-url-jakir]

### Wishing you a wonderful day! Keep in touch.

<!-- Personal profile -->

[linkedin-shield-jakir]: https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white
[linkedin-url-jakir]: https://www.linkedin.com/in/jakir-ruet/
[facebook-shield-jakir]: https://img.shields.io/badge/Facebook-%231877F2.svg?style=for-the-badge&logo=Facebook&logoColor=white
[facebook-url-jakir]: https://www.facebook.com/jakir.ruet/
[youtube-shield-jakir]: https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white
[youtube-url-jakir]: https://www.youtube.com/@mjakaria-ruet/featured
