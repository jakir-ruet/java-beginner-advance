```bash
payment-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jakirbd/
│   │   │       ├── PaymentSystemApplication.java
│   │   │       ├── config/
│   │   │       │   ├── DatabaseConfig.java
│   │   │       │   └── PaymentProcessorConfig.java
│   │   │       ├── model/
│   │   │       │   ├── Payment.java
│   │   │       │   ├── PaymentStatus.java
│   │   │       │   ├── PaymentRequest.java
│   │   │       │   └── PaymentResponse.java
│   │   │       ├── repository/
│   │   │       │   ├── PaymentRepository.java
│   │   │       │   └── PaymentRowMapper.java
│   │   │       ├── service/
│   │   │       │   ├── PaymentService.java
│   │   │       │   ├── PaymentProcessor.java
│   │   │       │   ├── CreditCardProcessor.java
│   │   │       │   ├── PayPalProcessor.java
│   │   │       │   └── CryptoProcessor.java
│   │   │       ├── controller/
│   │   │       │   └── PaymentController.java
│   │   │       ├── exception/
│   │   │       │   ├── PaymentNotFoundException.java
│   │   │       │   ├── PaymentProcessingException.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       └── util/
│   │   │           └── TransactionIdGenerator.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── db/
│   │           └── migration/
│   │               └── V1__Create_payments_table.sql
│   └── test/
│       └── java/
│           └── com/jakirbd/
│               ├── PaymentSystemApplicationTests.java
│               ├── service/
│               │   └── PaymentServiceTest.java
│               └── controller/
│                   └── PaymentControllerTest.java
```
