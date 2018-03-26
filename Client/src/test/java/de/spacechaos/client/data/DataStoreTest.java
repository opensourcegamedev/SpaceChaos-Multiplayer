package de.spacechaos.client.data;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.graphics.Color;

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
        assertSame(value, store.get(key, Color.class));

        assertNull(store.get("xya", String.class));
    }

    @Test(expected = NullPointerException.class)
    public void testNPE1() {
        DataStore store = new DataStore();
        store.put(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAE1() {
        DataStore store = new DataStore();
        store.put("", null);
    }

    @Test(expected = NullPointerException.class)
    public void testNPE2() {
        DataStore store = new DataStore();
        store.contains(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAE2() {
        DataStore store = new DataStore();
        store.contains("");
    }

    @Test(expected = NullPointerException.class)
    public void testNPE3() {
        DataStore store = new DataStore();
        store.get(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAE3() {
        DataStore store = new DataStore();
        store.get("");
    }

    @Test(expected = NullPointerException.class)
    public void testNPE4() {
        DataStore store = new DataStore();
        store.get(null, String.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAE4() {
        DataStore store = new DataStore();
        store.get("", String.class);
    }
    
    @Test(expected = NullPointerException.class)
    public void testNPE() {
        DataStore store = new DataStore();
        store.put("abc", null);
    }

}
