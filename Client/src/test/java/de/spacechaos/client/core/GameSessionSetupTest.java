package de.spacechaos.client.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import de.spacechaos.client.data.DataStore;
import de.spacechaos.client.data.GameMap;
import de.spacechaos.client.data.GameSessionSetup;
import de.spacechaos.client.data.GameSessionSetup.GameDifficulty;
import de.spacechaos.client.data.GameSessionSetup.GameMode;

/**
 * Tests the {@link GameSessionSetup} class.
 */
public class GameSessionSetupTest {

    @Test
    public void test() {
        final GameDifficulty difficulty = GameDifficulty.EASY;
        final GameMode mode = GameMode.CTF;
        final GameMap map = new GameMap();
        final long seed = 125L;

        GameSessionSetup setup = new GameSessionSetup(difficulty, mode, map, seed);
        assertSame(difficulty, setup.getDifficulty());
        assertSame(mode, setup.getMode());
        assertSame(map, setup.getMap());
        assertEquals(seed, setup.getSeed());

        setup = new GameSessionSetup();
        setup.setDifficulty(difficulty);
        setup.setMap(map);
        setup.setMode(mode);
        setup.setSeed(seed);

        assertSame(difficulty, setup.getDifficulty());
        assertSame(mode, setup.getMode());
        assertSame(map, setup.getMap());
        assertEquals(seed, setup.getSeed());
    }

}