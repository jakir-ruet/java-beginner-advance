### Master Spring Boot 3 & Spring Framework 6 with Java

Here we learn to become Java Spring Boot Full Stack Developer.

- Spring Framework,
- Spring Boot,
- Spring Data,
- Docker &
- AWS

#### Coupling

Coupling means how strongly **two** classes depend on each other.

1. **Tight Coupling (Bad design)** - One class directly creates and depends on another class.

```bash
# Pure Java
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine = new Engine(); // tightly coupled

    public void drive() {
        engine.start();
        System.out.println("Car is running");
    }
}
```

> **Problem**
>
> - `Car` is locked to `Engine`
> - If Engine changes → Car breaks
> - Hard to test and maintain

2. **Loose Coupling (Good Design)** - Classes depend on interfaces instead of concrete classes.

- Create Interface

```bash
interface Engine {
    void start();
}
```

- Implement Multiple Engines

```bash
class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol engine started");
    }
}
```

```bash
class DieselEngine implements Engine {
    public void start() {
        System.out.println("Diesel engine started");
    }
}
```

- Inject Dependency (Loose Coupling)

```bash
class Car {

    private Engine engine;

    public Car(Engine engine) {   // dependency injected
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is running");
    }
}
```

- Usage

```bash
public class Main {
    public static void main(String[] args) {

        Engine engine = new PetrolEngine(); // can switch easily
        Car car = new Car(engine);

        car.drive();
    }
}
```

**Object-Oriented Design (OOD)**

**1. Cohesion** measures how closely related the responsibilities and functionalities of a class are. A highly cohesive class has a single, well-defined purpose.

- High Cohesion (Good) - Only Login-Logout

```bash
public class AuthenticationService {

    public boolean login(String username, String password) {
        // authentication logic
        return true;
    }

    public void logout() {
        // logout logic
    }
}
```

- Low Cohesion (Bad) - Login, Send Email, generate Report & print Invoice.

```bash
public class UserManager {

    public void login() {}

    public void sendEmail() {}

    public void generateReport() {}

    public void printInvoice() {}
}
```

**2. Dependency Injection (DI)** It's a design pattern where an object receives its dependencies from an external source instead of creating them internally using new.

**Why Spring Boot uses DI** Spring Boot uses DI to:

- Reduce tight coupling
- Improve testability
- Make code scalable
- Manage object lifecycle automatically

**Without DI**

```bash
class Car {
    private Engine engine = new Engine(); // tightly coupled
}
```

**With DI**

```bash
class Car {
    private Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }
}
```

> The dependency (Engine) is “injected” from outside.

**Spring Container** It's the core engine of Spring Framework. It is responsible for:

- Creating objects
- Managing objects
- Wiring (injecting) dependencies
- Controlling object lifecycle
- Simple meaning:

> It is like a `factory` + `manager` for objects in your application.

```bash
@Service
public class CarService { }
```

> **Spring Container:**
>
> - Detects CarService
> - Creates its object
> - Keeps it ready in memory
> - Injects it wherever needed

**Types of Spring Container**
1. `BeanFactory` (basic, old)
2. `ApplicationContext` (modern, used in Spring Boot)

> Spring Boot uses `ApplicationContext`

**Bean** It's an object that is created and managed by the Spring Container.

**Without Spring**

```bash
CarService car = new CarService();
```

> You are manually creating object.

**With Spring (Bean)**

```bash
@Service
public class CarService { }
```

> **Now:**
> - Spring creates CarService object
> - That object is called a Bean

```bash
@Service
class EngineService { }

@Service
class CarService {
    private final EngineService engineService;

    public CarService(EngineService engineService) {
        this.engineService = engineService;
    }
}
```

**What Spring does:**
- Creates `EngineService` → Bean
- Creates `CarService` → Bean
- Injects `EngineService` into CarSe`r`vice

**Real-life analogy** Think of a restaurant kitchen system:

- **Beans = dishes** each prepared item (Pizza, Burger) = Bean

- **Container = kitchen**
  - Kitchen prepares food
  - Controls ingredients
  - Delivers dishes when needed

> You don’t cook yourself → kitchen does it.

**3. Interfaces and Abstraction** Abstraction hides implementation details and exposes only essential behavior. Interface defines a contract that implementing classes must follow.

**Interface**

```bash
public interface Payment {
    void pay(double amount);
}
```

**Credit Card Payment**

```bash
public class CreditCardPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Paid via Credit Card");
    }
}
```

**PayPal Payment**

```bash
public class PayPalPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Paid via PayPal");
    }
}
```

Correct order to learn

1. OOP (Foundation)
2. SOLID Principles (Design Rules)
3. OOD (Object-Oriented Design)
4. Design Patterns (Solutions)
