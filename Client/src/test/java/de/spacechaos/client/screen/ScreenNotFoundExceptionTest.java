package de.spacechaos.client.screen;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.spacechaos.client.setting.ConfigHandler;

/**
 * Tests the {@link ConfigHandler} class.
 */
public class ScreenNotFoundExceptionTest extends RuntimeException {

    @Test
    public void testBasics() {
        final String message = "xyz";
        ScreenNotFoundException ex = new ScreenNotFoundException(message);

        assertEquals(message, ex.getMessage());
    }

}
