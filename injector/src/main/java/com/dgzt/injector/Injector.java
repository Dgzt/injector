package com.dgzt.injector;

import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.dgzt.injector.exception.NewInstanceCreateException;

/**
 * The injector for runtime inject.
 */
public class Injector {

    // --------------------------------------------------
    // ~ Private members
    // --------------------------------------------------

    /**
     * The instance object
     */
    private static Injector instance;

    /**
     * The object holder map
     */
    private final ObjectMap<Class<?>, Object> objects;

    // --------------------------------------------------
    // ~ Constructors
    // --------------------------------------------------

    /**
     * The hidden constructor.
     */
    private Injector() {
        objects = new ObjectMap<Class<?>, Object>();
    }

    // --------------------------------------------------
    // ~ Public methods
    // --------------------------------------------------

    /**
     * @param clazz The class of object.
     * @param <T>   The type of object.
     * @return The object.
     */
    public static <T> T get(final Class<T> clazz) {
        createInstanceIfNecessary();

        if (!isInitialized(clazz)) {
            initialize(clazz);
        }

        return clazz.cast(instance.objects.get(clazz));
    }

    /**
     * @param clazz The checking class.
     * @param <T>   The type of class.
     * @return True if class has initialized otherwise false.
     */
    public static <T> boolean isInitialized(final Class<T> clazz) {
        createInstanceIfNecessary();

        return instance.objects.containsKey(clazz);
    }

    /**
     * Initializes the object.
     *
     * @param clazz The class.
     * @param <T>   The type of class
     */
    public static <T> void initialize(final Class<T> clazz) {
        createInstanceIfNecessary();

        try {
            final Constructor[] constructors = ClassReflection.getConstructors(clazz);

            if (constructors.length >= 1) {
                final Constructor constructor = constructors[0];
                final Class<?>[] parameterTypes = constructor.getParameterTypes();

                final Object[] parameters = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; ++i) {
                    parameters[i] = get(parameterTypes[i]);
                }

                instance.objects.put(clazz, constructor.newInstance(parameters));
            } else {
                throw new NewInstanceCreateException("The '" + clazz.getName() + "' has not constructor!");
            }
        } catch (final ReflectionException e) {
            throw new NewInstanceCreateException(e);
        }
    }

    /**
     * Initializes the class with the given object.
     *
     * @param clazz  The class of object.
     * @param object The object.
     * @param <T>    The type of class.
     */
    public static <T> void initialize(final Class<T> clazz, final T object) {
        createInstanceIfNecessary();

        instance.objects.put(clazz, object);
    }

    /**
     * Disposes the objects what implements {@link Disposable} interface
     * and clears the object map.
     */
    public static void dispose() {
        if (instance != null) {
            for (final ObjectMap.Entry<Class<?>, Object> entry : instance.objects.entries()) {
                if (entry.value instanceof Disposable) {
                    ((Disposable) entry.value).dispose();
                }
            }

            instance.objects.clear();
        }
    }

    // --------------------------------------------------
    // ~ Private methods
    // --------------------------------------------------

    private static void createInstanceIfNecessary() {
        if (instance == null) {
            instance = new Injector();
        }
    }

}
