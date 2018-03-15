package de.spacechaos.client.screen;

public class LobbyCreationScreen extends BaseUIScreen {

    @Override
    protected void initUI() {

    }

    @Override
    public void show() {
        game.getEventBus().register(this);
        // TODO Event Bus f�r Conection-Callback benutzen
    }

    @Override
    public void hide() {
        game.getEventBus().unregister(this);
    }

}
