package com.dgzt.injector.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.dgzt.injector.Injector;

public class InjectorExample extends Game {

    public static void main(final String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
        config.height = 800;
        config.samples = 4;
        new LwjglApplication(new InjectorExample(), config);
    }

    @Override
    public void create() {
        final Skin skin = new Skin(Gdx.files.internal("metal-ui.json"));
        Injector.initialize(Skin.class, skin);
        setScreen(Injector.get(Screen1.class));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        super.render();
    }
}
