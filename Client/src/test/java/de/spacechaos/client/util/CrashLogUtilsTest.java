package de.spacechaos.client.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.graphics.Color;

import de.spacechaos.client.data.DataStore;

/**
 * Tests the {@link CrashLogUtils} class.
 */
public class CrashLogUtilsTest {

    @Test
    public void testHandler() {
        assertNotNull(CrashLogUtils.CRASH_LOG_FILE);
    }

}
