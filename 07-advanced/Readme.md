### Design Principles

#### Coupling

Coupling means how strongly **two** classes depend on each other.

**1. Tight Coupling (Bad design)** - One class directly creates and depends on another class.

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

**2. Loose Coupling (Good Design)** - Classes depend on interfaces instead of concrete classes.

- Create Interface

```bash
interface Engine {
    void start();
}
```

- **Implement Multiple Engines**

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

- **Inject Dependency (Loose Coupling)**

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

- **Usage Case**

```bash
public class Main {
    public static void main(String[] args) {
        Engine engine = new PetrolEngine(); // can switch easily
        Car car = new Car(engine);
        car.drive();
    }
}
```

**3. Cohesion** measures how closely related the responsibilities and functionalities of a class are. A highly cohesive class has a single, well-defined purpose.

- **High Cohesion (Good) - Only Login-Logout**

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

- **Low Cohesion (Bad) - Login, Send Email, generate Report & print Invoice.**

```bash
public class UserManager {
    public void login() {}
    public void sendEmail() {}
    public void generateReport() {}
    public void printInvoice() {}
}
```

#### Dependency Injection

It's a design pattern where an object receives its dependencies from an external source instead of creating them internally using new.

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

**1. Constructor Injection - Recommended**

```bash
@Service
class UserService {
    private final UserRepository repository;  // Immutable (final)
    private final EmailService emailService;

    // Spring automatically injects dependencies
    public UserService(UserRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }
}
// ✅ Benefits: Immutable, testable, required dependencies clear
```

**2. Setter Injection**

```bash
@Service
class UserService {
    private EmailService emailService;  // Optional dependency

    @Autowired  // Optional
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
// ✅ Use for optional dependencies that can be changed at runtime
```

**3. Field Injection - Avoid**

```bash
@Service
class UserService {
    @Autowired  // Field injection - BAD PRACTICE
    private UserRepository repository;  // Non-final, hard to test
}
// ❌ Problems: Hard to test, breaks encapsulation, null pointer risks
```

#### Inversion of Control (IoC)

Inversion of Control (IoC) is a software design principle where the control of object creation and dependency management is handed over to a framework instead of being handled manually by the developer.

**Without IoC (Traditional Java)**

```bash
Engine engine = new PetrolEngine();
Car car = new Car(engine);
car.drive();
```

> **Problems:**
>
> - You create objects yourself
> - You decide dependencies manually
> - Hard to change implementations
> - Tight coupling

**With IoC (Spring Way)**

```bash
@Service
class CarService {
    private final EngineService engineService;
    public CarService(EngineService engineService) {
        this.engineService = engineService;
    }
}
```

> **Spring does everything:**
>
> - Creates objects
> - Chooses dependencies
> - Injects them automatically

| Without IoC                 | With IoC                           |
| --------------------------- | ---------------------------------- |
| You control object creation | Framework controls object creation |
| You wire dependencies       | Framework wires dependencies       |
| Manual lifecycle management | Automatic lifecycle management     |

#### Spring Container

The Spring Container is the core component of the Spring Framework that is responsible for `creating`, `configuring`, `managing`, and `destroying` application objects (beans) and handling their dependencies through Dependency Injection (DI). It's the core engine of Spring Framework. It is responsible for:

- Creating objects
- Managing objects
- Wiring (injecting) dependencies
- Controlling object lifecycle
- Simple meaning:

**Analogy**

| Role          | Spring Equivalent    |
| ------------- | -------------------- |
| Factory       | Spring Container     |
| Products      | Beans (objects)      |
| Assembly line | Dependency Injection |
| Manager       | ApplicationContext   |

##### Types of Spring Containers

1. BeanFactory - `Basic Container` - **Not used in modern Spring**
2. ApplicationContext - `Modern Container`
3. Spring Container Internal Workflow

**1. BeanFactory - `Basic Container` - Not used in modern Spring**

**Features:**

- Old and lightweight
- Loads beans lazily (on demand)
- Minimal features

```bash
BeanFactory factory = new XmlBeanFactory(resource);
```

**2. ApplicationContext - `Modern Container`**

**Features:**

- Eager bean creation (startup time)
- Event publishing
- AOP support
- Internationalization (i18n)
- Annotation-based config

```bash
ApplicationContext context =
    new AnnotationConfigApplicationContext(AppConfig.class);
```

**3. Spring Container Internal Workflow**

- @Component
- @Service
- @Repository
- @Controller

```bash
@ComponentScan(basePackages = "com.example")
```

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
