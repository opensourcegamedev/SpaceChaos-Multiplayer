package de.spacechaos.client.data;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.graphics.Color;

import de.spacechaos.client.data.DataStore;

/**
 * Tests the {@link DataStore} class.
 */
public class DataStoreTest {

    @Test
    public void testHandler() {
        final String key = "xyz";
        final Color value = new Color();

        DataStore store = new DataStore();
        assertTrue(!store.contains(key));

        store.put(key, value);
        assertTrue(store.contains(key));
        assertSame(value, store.get(key));
    }

}
