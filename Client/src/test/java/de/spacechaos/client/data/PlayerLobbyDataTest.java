package de.spacechaos.client.data;

import org.junit.Test;

import static org.junit.Assert.*;

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

        //test object with second constructor
        PlayerLobbyData dt2 = new PlayerLobbyData();
        assertNull(dt2.getUsername());
        assertEquals(0, dt2.getTeamId());

        dt2.setUsername(username2);
        dt2.setTeamId(id2);
        assertSame(username2, dt2.getUsername());
        assertEquals(id2, dt2.getTeamId());


    }

}
