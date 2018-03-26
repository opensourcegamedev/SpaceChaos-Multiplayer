package de.spacechaos.client.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.Input;

/**
 * Tests the {@link GameInputProcessor} class.
 */
public class GameInputProcessorTest {

    @Test
    public void test() {
        GameInputProcessor in = new GameInputProcessor();

        // A
        in.keyDown(Input.Keys.A);
        assertTrue(in.isLeftPressed());
        in.keyUp(Input.Keys.A);
        assertTrue(!in.isLeftPressed());
        // LEFT
        in.keyDown(Input.Keys.LEFT);
        assertTrue(in.isLeftPressed());
        in.keyUp(Input.Keys.LEFT);
        assertTrue(!in.isLeftPressed());

        // D
        in.keyDown(Input.Keys.D);
        assertTrue(in.isRightPressed());
        in.keyUp(Input.Keys.D);
        assertTrue(!in.isRightPressed());
        // RIGHT
        in.keyDown(Input.Keys.RIGHT);
        assertTrue(in.isRightPressed());
        in.keyUp(Input.Keys.RIGHT);
        assertTrue(!in.isRightPressed());

        // W
        in.keyDown(Input.Keys.W);
        assertTrue(in.isUpPressed());
        in.keyUp(Input.Keys.W);
        assertTrue(!in.isUpPressed());
        // UP
        in.keyDown(Input.Keys.UP);
        assertTrue(in.isUpPressed());
        in.keyUp(Input.Keys.UP);
        assertTrue(!in.isUpPressed());

        // S
        in.keyDown(Input.Keys.S);
        assertTrue(in.isDownPressed());
        in.keyUp(Input.Keys.S);
        assertTrue(!in.isDownPressed());
        // DOWN
        in.keyDown(Input.Keys.DOWN);
        assertTrue(in.isDownPressed());
        in.keyUp(Input.Keys.DOWN);
        assertTrue(!in.isDownPressed());

        // SPACE
        in.keyDown(Input.Keys.SPACE);
        assertTrue(in.isSpacePressed());
        in.keyUp(Input.Keys.SPACE);
        assertTrue(!in.isSpacePressed());

        // ESCAPE
        in.keyDown(Input.Keys.ESCAPE);
        assertTrue(in.isEscapePressed());
        in.keyUp(Input.Keys.ESCAPE);
        assertTrue(!in.isEscapePressed());

        // SPACE (*)
        in.keyDown(Input.Keys.SPACE);
        assertNotEquals(in.isSpaceJustPressed(), in.isSpacePressed());

        // ESCAPE (*)
        in.keyDown(Input.Keys.ESCAPE);
        assertNotEquals(in.isEscapeJustPressed(), in.isEscapePressed());

        // LEFT MOUSE
        in.touchDown(0, 0, 0, Input.Buttons.LEFT);
        assertTrue(in.isLeftMouseButtonPressed());
        in.touchUp(0, 0, 0, Input.Buttons.LEFT);
        assertTrue(!in.isLeftMouseButtonPressed());

        // RIGHT MOUSE
        in.touchDown(0, 0, 0, Input.Buttons.RIGHT);
        assertTrue(in.isRightMouseButtonPressed());
        in.touchUp(0, 0, 0, Input.Buttons.RIGHT);
        assertTrue(!in.isRightMouseButtonPressed());

        // LEFT MOUSE (*)
        in.touchDown(0, 0, 0, Input.Buttons.LEFT);
        assertNotEquals(in.isLeftMouseButtonJustPressed(), in.isLeftMouseButtonPressed());

        // RIGHT MOUSE (*)
        in.touchDown(0, 0, 0, Input.Buttons.RIGHT);
        assertNotEquals(in.isRightMouseButtonJustPressed(), in.isRightMouseButtonPressed());

        // SCROLL
        final int scrollAmount = 15;
        in.scrolled(scrollAmount);
        assertEquals(scrollAmount, in.getAmountJustScrolled());
        assertEquals(0, in.getAmountScrolled());

    }

}