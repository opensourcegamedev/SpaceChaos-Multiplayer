package de.spacechaos.client.util;

import de.spacechaos.client.GameUnitTest;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test(expected =  CrashLogUtils.ForceExit.class)
    public void testForceExit(){
        CrashLogUtils.writeCrashLogToFile(new NullPointerException("test"), true);
    }

    @Test
    public void testIOException() {
        try {
            new RandomAccessFile(CrashLogUtils.CRASH_LOG_FILE, "rw").getChannel().lock();
        } catch (IOException e) {
            System.err.println("Test failed");
        }
        CrashLogUtils.writeCrashLogToFile(new NullPointerException("test"), false);
    }

    @Test(expected = CrashLogUtils.ForceExit.class)
    public void testForceExitException(){
        throw new CrashLogUtils.ForceExit("Test message");
    }
}
