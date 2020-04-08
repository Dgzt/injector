# Injector

A library for [libgdx](https://libgdx.badlogicgames.com/), an open-source game development application framework written in java.

Injector is a dependency injector what injects objects at runtime, uses reflection. It can create object with its dependencies.

---

## Usage

Inject object:

```java
YourComponent component = Injector.get(YourComponent.class);
```

Dispose injector in your main dispose method:

```java
@Override
public void dispose () {
    ...
    Injector.dispose();
}
```

---

Example application uses the [Metal UI Skin](https://ray3k.wordpress.com/metal-ui-skin-for-libgdx/) created by Raymond "Raeleus" Buckley under the [CC BY license](https://creativecommons.org/licenses/by/4.0/). [Check out the others!](https://ray3k.wordpress.com/artwork/)
