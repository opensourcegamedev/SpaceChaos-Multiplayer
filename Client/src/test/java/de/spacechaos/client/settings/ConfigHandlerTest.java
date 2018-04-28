package de.spacechaos.client.settings;

import org.junit.Test;

import de.spacechaos.client.GameUnitTest;
import de.spacechaos.client.setting.ConfigHandler;
import de.spacechaos.client.setting.GameSettings;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Tests the {@link ConfigHandler} class.
 */
public class ConfigHandlerTest extends GameUnitTest {

    @Test(expected = NullPointerException.class)
    public void testNPE() {
        ConfigHandler cfg1 = new ConfigHandler(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAE() {
        ConfigHandler cfg2 = new ConfigHandler("");
    }

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
        assertTrue(cfg.hasValue(floatKey));
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

    /**
     * Checks the ConfigHandler with existing keys
     */
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

        assertEquals(floatValue, cfg.getFloat(floatKey, floatValue * 2), 0);
        assertEquals(intValue, cfg.getInt(intKey, intValue * 2));
        assertEquals(stringValue, cfg.getString(stringKey, stringValue + "abc"));
    }

    /**
     * Tests the ConfigHandler without existing keys.
     */
    @Test
    public void testWithoutValues(){
        final float floatValue = 2;
        final int intValue = 3;
        final String stringValue = "4";

        final String floatKey = "aa";
        final String intKey = "bb";
        final String stringKey = "cc";

        ConfigHandler cfg = new ConfigHandler("ABC");

        assertEquals(floatValue, cfg.getFloat(floatKey, floatValue), 0);
        assertEquals(intValue, cfg.getInt(intKey, intValue));
        assertEquals(stringValue, cfg.getString(stringKey, stringValue));

        assertEquals(floatValue, cfg.getFloat(floatKey, floatValue * 2), 0);
        assertEquals(intValue, cfg.getInt(intKey, intValue * 2));
        assertEquals(stringValue, cfg.getString(stringKey, stringValue + "abc"));

        // delete created preferences
        String path = System.getProperty("user.home") + "\\.prefs\\ABC";
        File file = new File(path);
        if(!file.delete()){
            fail();
            System.err.println("Couldn't delete preferences.");
        }
    }
}
