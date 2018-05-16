package de.spacechaos.client.core;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import de.spacechaos.client.GameUnitTest;
import de.spacechaos.client.data.GameSessionSetup;
import de.spacechaos.client.screen.BaseScreen;
import de.spacechaos.client.screen.LoadingScreen;
import de.spacechaos.client.screen.ScreenNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class SpaceChaosMultiplayerGameTest extends GameUnitTest {

    @Test
    public void baseTest(){
        BaseScreen screen = new BaseScreen() {
            @Override
            protected void onInit() {}

            @Override
            public void show() {}

            @Override
            public void render(float v) {}

            @Override
            public void hide() {}

            @Override
            public void dispose() {}
        };
        boolean debug = true;

        SpaceChaosMultiplayerGame game = new SpaceChaosMultiplayerGame(debug, true);
        game.addScreen("test_screen", screen);
        game.pushScreen("test_screen");
        screen.finishLoading();
        game.pushScreen("test_screen");
        Assert.assertEquals(screen, game.getScreen("test_screen"));

        Assert.assertEquals(debug, game.showDebugStuff());
    }

    @Test(expected = ScreenNotFoundException.class)
    public void testPushingNonExistentScreen(){
        SpaceChaosMultiplayerGame game = new SpaceChaosMultiplayerGame(true, true);
        game.pushScreen("test_screen");
    }

    @Test(expected = ScreenNotFoundException.class)
    public void testGettingNonExistentScreen(){
        SpaceChaosMultiplayerGame game = new SpaceChaosMultiplayerGame(true, true);
        game.getScreen("test_screen");
    }

    @Test
    public void testRestMethods(){
        Skin skin = new Skin();

        SpaceChaosMultiplayerGame game = new SpaceChaosMultiplayerGame(true, true);

        game.getAssetManager();
        game.getGameCamera();
        game.getUICamera();
        game.getSettings();

        game.setUISkin(skin);
        Assert.assertEquals(skin, game.getUISkin());
        game.setUISkin(null);
        Assert.assertNull(game.getUISkin());

        game.getSpriteBatch();
        game.getViewportWidth();
        game.getViewportHeight();

        game.getEventBus();
        game.getInputMultiplexer();
    }
}
