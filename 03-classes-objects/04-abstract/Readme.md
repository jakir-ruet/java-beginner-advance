**Abstraction means:** Hiding implementation details and showing only essential features.

**In simple words:** `What to do → visible.` `How it works → hidden.`

**Real-Life Example** for Car

- When driving a car:- You use:
  - steering
  - brake
  - accelerator

- But you do NOT know:
  - engine internals
  - fuel injection system
  - transmission logic

> You only use necessary features.

**Encapsulation vs Abstraction**

| Feature     | Encapsulation            | Abstraction                |
| ----------- | ------------------------ | -------------------------- |
| Focus       | Data hiding              | Implementation hiding      |
| Achieved by | Class + access modifiers | Abstract class / Interface |
| Hides       | Variables (data)         | Logic (implementation)     |
| Purpose     | Security + control       | Simplicity + design        |
| Level       | Code level               | Design level               |

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
