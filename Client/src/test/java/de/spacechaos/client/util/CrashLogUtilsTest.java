package de.spacechaos.client.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.badlogic.gdx.graphics.Color;

import de.spacechaos.client.GameUnitTest;
import de.spacechaos.client.data.DataStore;

/**
 * Tests the {@link CrashLogUtils} class.
 */
public class CrashLogUtilsTest extends GameUnitTest {

    @Test
    public void testHandler() {
        assertNotNull(CrashLogUtils.CRASH_LOG_FILE);

        CrashLogUtils.writeCrashLogToFile(new NullPointerException("test"));
        assertTrue(CrashLogUtils.CRASH_LOG_FILE.exists());

        CrashLogUtils.CRASH_LOG_FILE.delete();

        CrashLogUtils.writeCrashLogToFile(new NullPointerException("test"), false);
        assertTrue(CrashLogUtils.CRASH_LOG_FILE.exists());
    }

}
