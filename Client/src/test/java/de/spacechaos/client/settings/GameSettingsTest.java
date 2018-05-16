package de.spacechaos.client.settings;

import de.spacechaos.client.GameUnitTest;
import de.spacechaos.client.setting.GameSettings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link GameSettings} class.
 */
public class GameSettingsTest extends GameUnitTest {

    @Test
    public void test() {
        final float masterVolume = 2;
        final float effectVolume = 3;
        final float musicVolume = 4;

        GameSettings settings1 = new GameSettings("xyz");

        settings1.setMasterVolume(masterVolume);
        settings1.setEffectVolume(effectVolume);
        settings1.setMusicVolume(musicVolume);

        GameSettings settings2 = new GameSettings("xyz");
        assertEquals(masterVolume, settings2.getMasterVolume(), 0);
        assertEquals(effectVolume, settings2.getEffectVolume(), 0);
        assertEquals(musicVolume, settings2.getMusicVolume(), 0);

    }

}
