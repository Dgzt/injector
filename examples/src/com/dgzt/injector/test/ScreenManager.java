package com.dgzt.injector.test;

import com.badlogic.gdx.Gdx;
import com.dgzt.injector.Injector;

public class ScreenManager {

    public ScreenManager() {
        Gdx.app.log("", "Screen manager created");
    }

    public void goToScreen1() {
        final Screen1 screen1 = Injector.get(Screen1.class);
        ((InjectorExample)Gdx.app.getApplicationListener()).setScreen(screen1);
    }

    public void goToScreen2() {
        final Screen2 screen2 = Injector.get(Screen2.class);
        ((InjectorExample)Gdx.app.getApplicationListener()).setScreen(screen2);
    }

    public void goToScreen3() {
        final Screen3 screen3 = Injector.get(Screen3.class);
        ((InjectorExample)Gdx.app.getApplicationListener()).setScreen(screen3);
    }
}
