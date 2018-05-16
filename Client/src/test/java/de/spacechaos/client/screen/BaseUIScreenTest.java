package de.spacechaos.client.screen;

import org.junit.Test;

public class BaseUIScreenTest extends BaseScreenTest {

    @Test
    public void testScreen(){
        BaseUIScreen screen = new BaseUIScreen() {
            @Override
            protected void initUI() {}
        };

        screen.initUI();
        screen.dispose();
    }

    @Test(expected = NullPointerException.class)
    public void testWithoutStage(){
        BaseUIScreen screen = new BaseUIScreen() {
            @Override
            protected void initUI() {}
        };
        screen.resize(1, 1);
    }
}
