# Injector

[![](https://jitpack.io/v/Dgzt/injector.svg)](https://jitpack.io/#Dgzt/injector)
[![license](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/Dgzt/injector/blob/master/LICENSE)

---

A library for [libgdx](https://libgdx.badlogicgames.com/), an open-source game development application framework written in java.

Injector is a dependency injector what injects objects at runtime, uses reflection. It can create object with its dependencies.

---

## Including in Project

To use this in your gradle project, add the version number and jitpack repository information to your root build.gradle file:
 
```groovy
allprojects {
    ext {
    	...
        injectorVersion = '1.0.0'
    }
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```
And  in your core project add the dependency:
```groovy
dependencies {
    implementation "com.github.Dgzt:injector:$injectorVersion"
}
```

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
