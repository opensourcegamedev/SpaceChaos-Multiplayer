package de.spacechaos.client.screen;

public class LobbyScreen extends BaseUIScreen {

    @Override
    protected void initUI() {

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

}
