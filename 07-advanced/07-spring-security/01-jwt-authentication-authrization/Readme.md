### Overview

This is a very comprehensive Spring Security roadmap. It covers everything from beginner concepts to enterprise authentication and authorization. If your goal is to become a Java backend developer or Spring Security expert, this curriculum is strong. Here's what you'll learn, organized by skill level:

| Level            | Topics                                                                                     |
| ---------------- | ------------------------------------------------------------------------------------------ |
| **Beginner**     | Spring Security basics, Filters, Security Flow, Authentication, Basic Auth                 |
| **Intermediate** | Custom Security Config, UserDetailsService, JDBC Authentication, Password Encoders, BCrypt |
| **Advanced**     | Custom AuthenticationProvider, Session Management, HTTPS, Exception Handling, CSRF, CORS   |
| **Professional** | JWT Authentication, Method-Level Security, Custom Filters, Roles & Authorities             |
| **Expert**       | OAuth2, OpenID Connect, Keycloak, Spring Authorization Server, PKCE, MFA, Social Login     |

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
