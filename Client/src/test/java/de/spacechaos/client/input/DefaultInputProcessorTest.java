package de.spacechaos.client.input;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link DefaultInputProcessor} class.
 */
public class DefaultInputProcessorTest {

    @Test
    public void test() {
        DefaultInputProcessor in = new DefaultInputProcessor() {
        };

        assertTrue(!in.keyDown(2));
        assertTrue(!in.keyTyped((char) 5));
        assertTrue(!in.keyUp(3));
        assertTrue(!in.mouseMoved(8, 5));
        assertTrue(!in.scrolled(1));
        assertTrue(!in.touchDown(4, 7, 8, 6));
        assertTrue(!in.touchDragged(1, 4, 4));
        assertTrue(!in.touchUp(4, 1, 1, 5));
    }

}