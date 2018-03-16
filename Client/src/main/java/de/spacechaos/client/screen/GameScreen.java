package de.spacechaos.client.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import de.spacechaos.client.input.GameInputProcessor;

/**
 * This screen is the main game screen and displays the battlefield.
 */
public class GameScreen extends BaseScreen {

    private GameInputProcessor gameInputProcessor;

    @Override
    protected void onInit() {
        this.gameInputProcessor = new GameInputProcessor();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, backgroundColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getCurrentSession().render(delta);

    }

    @Override
    public void show() {
        game.getInputMultiplexer().addProcessor(gameInputProcessor);
        game.getEventBus().register(this);
        // TODO Event Bus f�r Chat-Nachrichten, etc. benutzen
    }

    @Override
    public void hide() {
        game.getInputMultiplexer().removeInputProcessors();
        game.getEventBus().register(this);
    }

    @Override
    public void dispose() {

    }

}
