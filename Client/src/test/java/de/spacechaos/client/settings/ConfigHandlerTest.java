package de.spacechaos.client.settings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.spacechaos.client.GameUnitTest;
import de.spacechaos.client.setting.ConfigHandler;
import de.spacechaos.client.setting.GameSettings;

/**
 * Tests the {@link ConfigHandler} class.
 */
public class ConfigHandlerTest extends GameUnitTest {

    @Test
    public void testBasics() {
        final float floatValue = 2;
        final int intValue = 3;
        final String stringValue = "4";

        final String floatKey = "a";
        final String intKey = "b";
        final String stringKey = "c";

        ConfigHandler cfg = new ConfigHandler("XYZ");
        cfg.setFloat(floatKey, floatValue);
        cfg.setInt(intKey, intValue);
        cfg.setString(stringKey, stringValue);

        assertEquals(floatValue, cfg.getFloat(floatKey), 0);
        assertEquals(intValue, cfg.getInt(intKey));
        assertEquals(stringValue, cfg.getString(stringKey));

        cfg.addToFloat(floatKey, floatValue);
        cfg.addToInt(intKey, intValue);

        assertEquals(floatValue * 2, cfg.getFloat(floatKey), 0.001F);
        assertEquals(intValue * 2, cfg.getInt(intKey));

    }

    @Test
    public void testDefaults() {
        final float floatValue = 2;
        final int intValue = 3;
        final String stringValue = "4";

        final String floatKey = "aa";
        final String intKey = "bb";
        final String stringKey = "cc";

        ConfigHandler cfg = new ConfigHandler("XYZ");

        assertEquals(floatValue, cfg.getFloat(floatKey, floatValue), 0);
        assertEquals(intValue, cfg.getInt(intKey, intValue));
        assertEquals(stringValue, cfg.getString(stringKey, stringValue));
    }
}
