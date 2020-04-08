package com.dgzt.injector.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dgzt.injector.Injector;

public class Screen1 extends ScreenAdapter {

    private final Stage stage;

    public Screen1() {
        Gdx.app.log("", "Screen1 created");
        stage = new Stage(new ScreenViewport());

        final Skin skin = Injector.get(Skin.class);

        final TextButton screen2Button = new TextButton("Screen 2", skin);
        screen2Button.addListener(new Screen2ButtonClickListener());

        final TextButton screen3Button = new TextButton("Screen 3", skin);
        screen3Button.addListener(new Screen3ButtonClickListener());

        final Window mainTable = new Window("Screen 1", skin);
        mainTable.setFillParent(true);
        mainTable.defaults().space(20);
        mainTable.add(screen2Button);
        mainTable.add(screen3Button);

        stage.addActor(mainTable);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    private class Screen2ButtonClickListener extends ClickListener {

        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            final ScreenManager screenManager = Injector.get(ScreenManager.class);
            screenManager.goToScreen2();
        }
    }

    private class Screen3ButtonClickListener extends ClickListener {

        @Override
        public void clicked(InputEvent event, float x, float y) {
            super.clicked(event, x, y);
            final ScreenManager screenManager = Injector.get(ScreenManager.class);
            screenManager.goToScreen3();
        }
    }
}
