package com.dgzt.injector;

import com.dgzt.injector.classes.ComponentA;
import com.dgzt.injector.classes.ComponentBDependsOnA;
import com.dgzt.injector.classes.ComponentImplementsDisposable;
import com.dgzt.injector.classes.ComponentWithoutConstructor;
import com.dgzt.injector.exception.NewInstanceCreateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InjectorTest {

    @BeforeEach
    public void setup() {
        Injector.dispose();
    }

    @Test
    public void testGetSimpleClass() {
        final ComponentA componentA = Injector.get(ComponentA.class);

        assertNotNull(componentA);
        assertTrue(Injector.isInitialized(ComponentA.class));
    }

    @Test
    public void testGetWhatHasDependenciesToo() {
        final ComponentBDependsOnA componentB = Injector.get(ComponentBDependsOnA.class);

        assertNotNull(componentB);
        assertNotNull(componentB.getComponentA());
        assertTrue(Injector.isInitialized(ComponentBDependsOnA.class));
        assertTrue(Injector.isInitialized(ComponentA.class));
    }

    @Test
    public void testClassHasNotConstructor() {
        assertThrows(NewInstanceCreateException.class, new Executable() {
            @Override
            public void execute() {
                Injector.get(ComponentWithoutConstructor.class);
            }
        });
    }

    @Test
    public void testGivenObject() {
        final ComponentA componentA = new ComponentA();

        Injector.initialize(ComponentA.class, componentA);

        assertEquals(componentA, Injector.get(ComponentA.class));
    }

    @Test
    public void testDisposeDisableableObjects() {
        final ComponentImplementsDisposable component = mock(ComponentImplementsDisposable.class);

        Injector.initialize(ComponentImplementsDisposable.class, component);

        Injector.dispose();

        verify(component).dispose();
    }
}
