### Generics

Generics in Java allow you to write `type-safe` and `reusable code` by enabling `classes`, `interfaces`, and `methods` to operate on different data types while providing compile-time type checking.

**Benefits**

- Type safety (compile-time checking)
- No casting needed
- Reusable code
- Cleaner and more readable code
- Reduces runtime errors

**Before Generics (Raw Type Problem)**

```bash
Box box = new Box();
box.set("Hello");        			// Put String
String str = (String) box.get();	// Need cast!
```

> **Problems:**
>
> - No type safety
> - Runtime ClassCastException
> - Need explicit casting

**With Generics (Type Safe)**

```bash
Box<String> box = new Box<>();
box.set("Hello");       		// Only String allowed
String str = box.get();  		// No cast needed! ✅
```
