package de.spacechaos.client.screen;

/**
 * This screen is the main game screen and displays the battlefield.
 */
public class GameRespawnScreen extends BaseUIScreen {

    @Override
    protected void initUI() {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        game.getEventBus().register(this);
        // TODO Event Bus f�r Chat-Nachrichten, etc. benutzen
    }

    @Override
    public void hide() {
        game.getEventBus().unregister(this);
    }

    @Override
    public void dispose() {

    }

}
