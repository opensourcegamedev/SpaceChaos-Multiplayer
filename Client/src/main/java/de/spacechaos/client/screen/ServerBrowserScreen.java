package de.spacechaos.client.screen;

public class ServerBrowserScreen extends BaseUIScreen {

    @Override
    protected void initUI() {

    }

    @Override
    public void show() {
        game.getEventBus().register(this);
        // TODO Event Bus f�r Connecting-Callback benutzen
    }

    @Override
    public void hide() {
        game.getEventBus().unregister(this);
    }

}
