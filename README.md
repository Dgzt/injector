# Injector

A library for [libgdx](https://libgdx.badlogicgames.com/), an open-source game development application framework written in java.

Injector injects objects at runtime, uses reflection. It can create object with its dependencies.

---

## Usage

```java
YourComponent component = Injector.get(YourComponent.class);
```

---

Example application uses the [Metal UI Skin](https://ray3k.wordpress.com/metal-ui-skin-for-libgdx/) created by Raymond "Raeleus" Buckley under the [CC BY license](https://creativecommons.org/licenses/by/4.0/). [Check out the others!](https://ray3k.wordpress.com/artwork/)
