package com.dgzt.injector.classes;

public class ComponentBDependsOnA {

    private final ComponentA componentA;

    public ComponentBDependsOnA(final ComponentA componentA) {
        this.componentA = componentA;
    }

    public ComponentA getComponentA() {
        return componentA;
    }
}
