### Overview

This is a very comprehensive Spring Security roadmap. It covers everything from beginner concepts to enterprise authentication and authorization. If your goal is to become a Java backend developer or Spring Security expert, this curriculum is strong. Here's what you'll learn, organized by skill level:

| Level            | Topics                                                                                     |
| ---------------- | ------------------------------------------------------------------------------------------ |
| **Beginner**     | Spring Security basics, Filters, Security Flow, Authentication, Basic Auth                 |
| **Intermediate** | Custom Security Config, UserDetailsService, JDBC Authentication, Password Encoders, BCrypt |
| **Advanced**     | Custom AuthenticationProvider, Session Management, HTTPS, Exception Handling, CSRF, CORS   |
| **Professional** | JWT Authentication, Method-Level Security, Custom Filters, Roles & Authorities             |
| **Expert**       | OAuth2, OpenID Connect, Keycloak, Spring Authorization Server, PKCE, MFA, Social Login     |

### Spring Boot Security with OWASP Compliance

1. Project Setup & Dependencies
2. Database Design & Entities
3. Security Configuration (OWASP Compliant)
4. JWT Implementation
5. Authentication Service
6. Authorization & RBAC
7. Security Headers & CSRF Protection
8. Rate Limiting & Brute Force Protection
9. Audit Logging & Monitoring
10. Testing Security
11. Docker & Production Deployment
12. Security Checklist & OWASP Compliance Matrix

#### OWASP Top 10 Compliance Matrix

| OWASP Risk                                            | Spring Boot Implementation                                                      |
| ----------------------------------------------------- | ------------------------------------------------------------------------------- |
| A01:2021 – Broken Access Control                      | `@PreAuthorize`, `@PostAuthorize`, Role hierarchy, Custom `PermissionEvaluator` |
| A02:2021 – Cryptographic Failures                     | `BCryptPasswordEncoder` (work factor 12), HTTPS enforcement, JWT signatures     |
| A03:2021 – Injection                                  | JPA parameterized queries, Input validation (`@Valid`), Output encoding         |
| A04:2021 – Insecure Design                            | Defense in depth, Security by default, Principle of least privilege             |
| A05:2021 – Security Misconfiguration                  | Secure defaults, Security headers, CSRF protection, No stack traces             |
| A06:2021 – Vulnerable and Outdated Components         | OWASP Dependency-Check, Regular updates, Vulnerability scanning                 |
| A07:2021 – Identification and Authentication Failures | MFA support, Password policies, Account lockout, Session fixation protection    |
| A08:2021 – Software and Data Integrity Failures       | Refresh token rotation, Audit logging, Signed JWT tokens                        |
| A09:2021 – Security Logging and Monitoring Failures   | Comprehensive audit logs, Rate limiting alerts, Failed login tracking           |
| A10:2021 – Server-Side Request Forgery (SSRF)         | Input validation, URL whitelisting, Network segmentation                        |

#### Major concepts covered

1. Spring Security Architecture
   - Security Filter Chain
   - Servlet Filters
   - Authentication flow
   - Authorization flow
   - SecurityContext
   - Authentication object

2. User Management
	- InMemoryUserDetailsManager
	- JdbcUserDetailsManager
	- Custom UserDetailsService
	- Registration APIs
	- MySQL integration

3. Password Security
	- BCrypt
	- PasswordEncoder
	- Hashing
	- Encoding vs Encryption
	- Rainbow table attacks
	- Brute force attacks

4. Authentication
	-	HTTP Basic
	- Form Login
	- Custom AuthenticationProvider
	- AuthenticationManager
	- JWT Authentication

5. Authorization
	- Roles
	- Authorities
	- Method Security
	- @PreAuthorize
	- @PostAuthorize
	- @PreFilter
	- @PostFilter

6. Security Attacks
	- CSRF
	- CORS
	- Session Fixation
	- Session Hijacking
	- HTTPS
	- Concurrent Sessions

7. Customization
	- Custom Filters
	- AuthenticationEntryPoint
	- AccessDeniedHandler
	- Authentication Events
	- Environment-specific configurations

8. JWT
	- JWT structure
	- JWT generation
	- JWT validation
	- Expiration
	- Stateless authentication

9. OAuth2 - The course explains almost every OAuth2 flow:
	- Authorization Code
	- PKCE
	- Client Credentials
	- Refresh Token
	- Password Grant (legacy)
	- Implicit Grant (legacy)

10. OpenID Connect
	- Identity layer over OAuth2
	- User authentication
	- ID Tokens

#### Servlet and Filter

**Servlet** A Servlet is a Java server-side component that receives HTTP requests, executes business logic, and generates HTTP responses for the client.

**Filter** A Filter is a Java component that intercepts HTTP requests and responses before or after they reach a Servlet, allowing cross-cutting tasks such as authentication, authorization, logging, validation, and request/response modification.

![Servlet and Filter](/img/servlet-filters.png)

**Easy Comparison**

| Servlet                        | Filter                                 |
| ------------------------------ | -------------------------------------- |
| Handles business logic         | Intercepts requests and responses      |
| Processes HTTP requests        | Performs pre/post processing           |
| Generates HTTP responses       | Does not generate business responses   |
| Endpoint of the request        | Executes before and/or after a Servlet |
| Example: `doGet()`, `doPost()` | Example: `doFilter()`                  |

**Spring Security Internal Flow**

![Spring Security Internal Flow](/img/sb-security-flow.png)

**Spring Security Filters** - A chain of Spring Security filters intercepts every incoming HTTP request. The filters determine whether authentication or authorization is required and perform tasks such as JWT validation, session management, CSRF protection, and request processing before the request reaches the application.

**Authentication** - The Authentication object represents the current user's identity and authentication status. Filters such as UsernamePasswordAuthenticationFilter or a custom JwtAuthenticationFilter create this object from the incoming request and pass it to the authentication process.

**AuthenticationManager** - The AuthenticationManager coordinates the authentication process. It receives the Authentication object from the filter and delegates authentication to the appropriate AuthenticationProvider.

**AuthenticationProvider** - An AuthenticationProvider contains the core authentication logic. It validates the user's credentials, loads user information, verifies the password, and returns an authenticated Authentication object when validation succeeds.

**UserDetailsService/UserDetailsManager** UserDetailsService loads user information such as username, password, roles, and account status from the database or another data source.

> UserDetailsManager extends UserDetailsService by providing additional operations to create, update, and delete user accounts.

**PasswordEncoder** - PasswordEncoder securely hashes passwords before they are stored and verifies a user's raw password against the encoded password during authentication. This ensures that plain-text passwords are never stored.

**SecurityContext** - After successful authentication, the authenticated Authentication object is stored in the SecurityContext. Managed by the SecurityContextHolder, it makes the authenticated user's security information available throughout the current request and, depending on the security configuration, across subsequent requests.

**Security sequence Flow**

![Security sequence Flow](/img/security-sequence-flow.png)

![Security sequence Flow](/img/security-sequence-flow1.png)

**User Management**

![User Management](/img/user-management.png)

**JSON Web Token Auth Process**

![User Management](/img/jwt-security-flow.jpeg)

![JWT-Token-Validation](/img/jwt-token-validation.png)

### CORS

Cross-Origin Resource Sharing (CORS) is a browser security mechanism that controls whether a web application running on one origin can access resources from another origin. An origin is defined by the combination of:

- Protocol (HTTP/HTTPS)
- Domain (Hostname)
- Port

![CORS](/img/cors-process.png)

### CSRF

Cross-Site Request Forgery (CSRF) is an attack in which a malicious website tricks a user's browser into sending an unauthorized request to another website where the user is already authenticated.

Unlike CORS, CSRF is not a browser restriction. It is an attack that exploits automatically sent credentials such as session cookies.

![CSRF](/img/csrf-process.png)

| Feature          | CORS                                   | CSRF                                 |
| ---------------- | -------------------------------------- | ------------------------------------ |
| Full Form        | Cross-Origin Resource Sharing          | Cross-Site Request Forgery           |
| Purpose          | Controls cross-origin resource sharing | Prevents forged requests             |
| Nature           | Browser security policy                | Security attack                      |
| Protects Against | Unauthorized cross-origin access       | Unauthorized state-changing requests |
| Enforced By      | Browser                                | Server                               |
| Uses Tokens      | No                                     | Yes (typically)                      |
| Uses Cookies     | Optional                               | Usually exploits cookies             |
| Common in        | SPA + REST APIs                        | Session-based web applications       |
| Spring Security  | `http.cors()`                          | `http.csrf()`                        |

### Method Level Security

Method Level Security allows you to apply authorization rules directly to Java methods using annotations. Instead of protecting URLs like:

```bash
GET /api/users/**
```

We protect methods like:

```bash
public User getUser(Long id)
```

Using annotations such as:

```bash
@PreAuthorize("hasRole('ADMIN')")
```

Without Method Security

```bash
Client
   │
   ▼
Security Filter
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
```

With Method Security

```bash
Client
   │
   ▼
Security Filter
   │
   ▼
Controller
   │
   ▼
@PreAuthorize
Service
   │
   ▼
@PostAuthorize
Repository
```

| Annotation       | Purpose                                      | Supports SpEL |
| ---------------- | -------------------------------------------- | ------------- |
| `@PreAuthorize`  | Checks authorization before method execution | Yes           |
| `@PostAuthorize` | Checks authorization after method execution  | Yes           |
| `@PreFilter`     | Filters method parameters before execution   | Yes           |
| `@PostFilter`    | Filters returned collections after execution | Yes           |
| `@Secured`       | Simple role-based authorization              | No            |
| `@RolesAllowed`  | Java standard role-based authorization       | No            |

> Spring Expression Language (SpEL)

### OAuth 2.0

OAuth 2.0 (Open Authorization 2.0) is an authorization framework that allows a user to grant a third-party application limited access to their resources without sharing their password. It is important to understand:

- Authentication answers "Who are you?"
- Authorization answers "What are you allowed to access?"

> OAuth 2.0 primarily focuses on authorization, although it is commonly used together with OpenID Connect (OIDC) for authentication.

![OAuth 2.0](/img/oauth2-flow.png)
