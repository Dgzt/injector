# Injector

A library for [libgdx](https://libgdx.badlogicgames.com/), an open-source game development application framework written in java.

Injector injects objects at runtime, uses reflection. It can create object with its dependencies.

---

## Usage

```java
YourComponent component = Injector.get(YourComponent.class);
```
