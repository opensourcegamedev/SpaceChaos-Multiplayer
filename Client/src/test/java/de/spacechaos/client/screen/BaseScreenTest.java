package de.spacechaos.client.screen;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.spacechaos.client.GameUnitTest;

/**
 * Tests the {@link BaseScreen} class. Should get extended by the tests for
 * children of {@link BaseScreen}
 */
public class BaseScreenTest extends GameUnitTest {

    private void testBasicStuff(BaseScreen s) {
        s.pause();
        s.resume();

        s.init(null, null);
        
        s.finishLoading();
        assertTrue(s.isLoaded());
    }

    @Test
    public void test() {
        BaseScreen s = new BaseScreen() {
            @Override
            public void show() {
            }

            @Override
            public void render(float delta) {
            }

            @Override
            public void hide() {
            }

            @Override
            public void dispose() {
            }

            @Override
            protected void onInit() {
            }
        };
        
        testBasicStuff(s);
        s.resize(15, 15);
    }

}
