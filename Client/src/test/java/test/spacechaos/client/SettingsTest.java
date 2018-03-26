package test.spacechaos.client;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import de.spacechaos.client.setting.GameSettings;

/**
 * Tests the {@link GameSettings} class.
 */
public class SettingsTest {

    @Test
    public void testHandler() {
        final float masterVolume = 2;
        final float effectVolume = 3;
        final float musicVolume = 4;

        GameSettings settings1 = new GameSettings("xyz");

        settings1.setMasterVolume(masterVolume);
        settings1.setEffectVolume(effectVolume);
        settings1.setMusicVolume(musicVolume);

        GameSettings settings2 = new GameSettings("xyz");
        assertSame(masterVolume, settings2.getEffectVolume());
        assertSame(effectVolume, settings2.getEffectVolume());
        assertSame(musicVolume, settings2.getEffectVolume());

    }

}
