package de.spacechaos.client.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import de.spacechaos.client.data.DataStore;

/**
 * Tests the {@link PositionConverter} class.
 */
public class PositionConverterTest {

    @Test
    public void testHandler() {
        final int unit = 1258;
        assertEquals(1258, PositionConverter.toPixels(PositionConverter.toPhysicUnits(1258)));

        final Vector2 vector = new Vector2(589, 745);
        final Vector2 vector2 = PositionConverter.toPixels(PositionConverter.toPhysicUnits(vector));

        assertEquals(vector.x, vector2.x, 0);
        assertEquals(vector.y, vector2.y, 0);
    }

}
