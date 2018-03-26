package de.spacechaos.client.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Tests the {@link PlayerLobbyData} class.
 */
public class PlayerLobbyDataTest {

    @Test
    public void testHandler() {
        final String username = "xyz";
        final short id = 2;

        PlayerLobbyData dt = new PlayerLobbyData(username, id);
        assertSame(username, dt.getUsername());
        assertEquals(id, dt.getTeamId());

        final String username2 = "abc";
        final short id2 = 3;
        dt.setUsername(username2);
        dt.setTeamId(id2);
        assertSame(username2, dt.getUsername());
        assertEquals(id2, dt.getTeamId());
    }

}
