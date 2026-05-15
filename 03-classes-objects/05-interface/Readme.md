### Interface

An interface in Java is a blueprint of a class that defines a set of abstract methods which implementing classes must provide. It specifies:

- what a class should do
- but not how it should do it

### What changed conceptually?

1. Before (Abstract Class)
   - Shared method inside parent class
   - Tight relationship (is-a base class)

**Should See**

```txt
Payment Processing...
Paid using Credit Card
-----------

Payment Processing...
Paid using Paypal
```

2. Now (Interface)
   - Only defines behavior
   - No shared logic inside contract
   - More flexible design

**Should See**

```txt
Paying with credit card
-------------
Paying with PayPal
```
